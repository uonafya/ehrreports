/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ehrreports.page.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.report.ReportRequest;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.openmrs.module.reporting.report.definition.service.ReportDefinitionService;
import org.openmrs.module.reporting.report.renderer.RenderingMode;
import org.openmrs.module.reporting.report.service.ReportService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.WebConstants;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

/** */
public class RunReportPageController {
	
	public void get(@SpringBean ReportDefinitionService reportDefinitionService, @SpringBean ReportService reportService,
	        @RequestParam("reportDefinition") String reportDefinitionUuid,
	        @RequestParam(value = "breadcrumb", required = false) String breadcrumb, PageModel model) throws Exception {
		
		ReportDefinition reportDefinition = reportDefinitionService.getDefinitionByUuid(reportDefinitionUuid);
		if (reportDefinition == null) {
			throw new IllegalArgumentException("No reportDefinition with the given uuid");
		}
		model.addAttribute("reportDefinition", reportDefinition);
		model.addAttribute("renderingModes", reportService.getRenderingModes(reportDefinition));
		model.addAttribute("breadcrumb", breadcrumb);
	}
	
	public String post(@SpringBean ReportDefinitionService reportDefinitionService, @SpringBean ReportService reportService,
	        UiUtils ui, HttpServletRequest request, @RequestParam("reportDefinition") ReportDefinition reportDefinition,
	        @RequestParam("renderingMode") String renderingModeDescriptor) {
		
		RenderingMode renderingMode = null;
		for (RenderingMode candidate : reportService.getRenderingModes(reportDefinition)) {
			if (candidate.getDescriptor().equals(renderingModeDescriptor)) {
				renderingMode = candidate;
				break;
			}
		}
		
		Collection<Parameter> missingParameters = new ArrayList<Parameter>();
		Map<String, Object> parameterValues = new HashMap<String, Object>();
		for (Parameter parameter : reportDefinition.getParameters()) {
			String submitted = request.getParameter("parameterValues[" + parameter.getName() + "]");
			if (parameter.getCollectionType() != null) {
				throw new IllegalStateException("Collection parameters not yet implemented");
			}
			Object converted;
			if (StringUtils.isEmpty(submitted)) {
				converted = parameter.getDefaultValue();
			} else {
				converted = ui.convert(submitted, parameter.getType());
			}
			if (converted == null) {
				missingParameters.add(parameter);
			}
			parameterValues.put(parameter.getName(), converted);
		}
		if (missingParameters.size() > 0) {
			request.getSession().setAttribute(WebConstants.OPENMRS_ERROR_ATTR,
			    ui.message("reportingui.runReport.missingParameter"));
			return "redirect:"
			        + ui.pageLink("reportingui", "runReport",
			            SimpleObject.create("reportDefinition", reportDefinition.getUuid()));
		}
		
		ReportRequest reportRequest = new ReportRequest();
		reportRequest.setReportDefinition(new Mapped<ReportDefinition>(reportDefinition, parameterValues));
		reportRequest.setRenderingMode(renderingMode);
		// rr.setBaseCohort(command.getBaseCohort());
		// rr.setSchedule(command.getSchedule());
		
		// TODO: We might want to check here if this exact same report request is already queued and
		// just re-direct if so
		
		reportRequest = reportService.queueReport(reportRequest);
		reportService.processNextQueuedReports();
		
		return "redirect:"
		        + ui.pageLink("reportingui", "runReport",
		            SimpleObject.create("reportDefinition", reportDefinition.getUuid()));
	}
}

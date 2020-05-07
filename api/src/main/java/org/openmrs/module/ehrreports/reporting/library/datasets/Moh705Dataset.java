/*
 * The contents of this file are subject to the OpenMRS Public License Version
 * 1.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.reporting.library.dimensions.AgeDimensionCohortInterface;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Moh705Dataset extends BaseDataSet {
	
	@Autowired
	private EhrCommonDimension ehrCommonDimension;
	
	@Autowired
	@Qualifier("commonAgeDimensionCohort")
	private AgeDimensionCohortInterface ageDimensionCohort;
	
	public DataSetDefinition constructMoh705Dataset() {
		
		CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
		dsd.setName("MOH 705 Data Set");
		dsd.addParameters(getParameters());
		// Tie dimensions to this data definition
		dsd.addDimension("gender", EhrReportUtils.map(ehrCommonDimension.gender(), ""));
		dsd.addDimension("age", EhrReportUtils.map(ehrCommonDimension.age(ageDimensionCohort), "effectiveDate=${endDate}"));
		// add your dataset here, construct it here
		return dsd;
	}
}

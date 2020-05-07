package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.datasets.Moh717Dataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.reporting.ReportingException;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupMoh717Report extends EhrDataExportManager {
	
	@Autowired
	private Moh717Dataset moh717Dataset;
	
	@Override
	public String getExcelDesignUuid() {
		return "8e26e9aa-8f72-11ea-8404-0be251dd2c08";
	}
	
	@Override
	public String getUuid() {
		return "9ce0f968-8f72-11ea-a3fc-077b8af7e776";
	}
	
	@Override
	public String getName() {
		return "MOH 717 Report";
	}
	
	@Override
	public String getDescription() {
		return "MOH 717 work load Indicators";
	}
	
	@Override
	public ReportDefinition constructReportDefinition() {
		ReportDefinition rd = new ReportDefinition();
		
		rd.setUuid(getUuid());
		rd.setName(getName());
		rd.setDescription(getDescription());
		// tie the dataset here, you can add more than one data set definition
		rd.addDataSetDefinition("MOH717", Mapped.mapStraightThrough(moh717Dataset.constructMoh717Dataset()));
		return rd;
	}
	
	@Override
	public String getVersion() {
		return "1.0-SNAPSHOT";
	}
	
	@Override
	public List<ReportDesign> constructReportDesigns(ReportDefinition reportDefinition) {
		ReportDesign reportDesign = null;
		try {
			reportDesign = createXlsReportDesign(reportDefinition, "MOH_717.xls", "MOH717-Report", getExcelDesignUuid(),
			    null);
			Properties props = new Properties();
			props.put("sortWeight", "5000");
			reportDesign.setProperties(props);
		}
		catch (IOException e) {
			throw new ReportingException(e.toString());
		}
		
		return Arrays.asList(reportDesign);
	}
}

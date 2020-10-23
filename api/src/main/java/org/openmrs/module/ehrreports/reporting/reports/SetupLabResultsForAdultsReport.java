package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.datasets.LabAdultsResultsDataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupLabResultsForAdultsReport extends EhrDataExportManager {
  @Autowired private LabAdultsResultsDataset labResultsDataset;

  @Override
  public String getExcelDesignUuid() {
    return "c364f84c-1522-11eb-b077-639d584af670";
  }

  @Override
  public String getUuid() {
    return "ce843508-1522-11eb-a0cc-abad2e93f2b5";
  }

  @Override
  public String getName() {
    return "Laboratory Results Report for adults";
  }

  @Override
  public String getDescription() {
    return "Displaying of the laboratory results for patient aged 15 years and above";
  }

  @Override
  public ReportDefinition constructReportDefinition() {
    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setUuid(getUuid());
    reportDefinition.setName(getName());
    reportDefinition.setDescription(getDescription());
    reportDefinition.setParameters(labResultsDataset.getParameters());
    // tie the dataset here, you can add more than one data set definition
    reportDefinition.addDataSetDefinition(
        "ADULT",
        Mapped.mapStraightThrough(labResultsDataset.constructLabResultsForAdultsDataset()));
    return reportDefinition;
  }

  @Override
  public String getVersion() {
    return "1.0-SNAPSHOT";
  }

  @Override
  public List<ReportDesign> constructReportDesigns(ReportDefinition reportDefinition) {
    ReportDesign reportDesign = null;
    try {
      reportDesign =
          createXlsReportDesign(
              reportDefinition,
              "labadults.xls",
              "LAB RESULTS REPORT ADULTS",
              getExcelDesignUuid(),
              null);
      Properties props = new Properties();
      props.put("repeatingSections", "sheet:1,row:4,dataset:ADULT");
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return Arrays.asList(reportDesign);
  }
}

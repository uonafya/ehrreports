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
public class SetupLabResultsReport extends EhrDataExportManager {

  @Autowired private LabAdultsResultsDataset labResultsDataset;

  @Override
  public String getExcelDesignUuid() {
    return "740b48ba-fe60-11ea-80b2-474f904acfbf";
  }

  @Override
  public String getUuid() {
    return "c58b8014-fe89-11ea-b24c-f7edd9942c04";
  }

  @Override
  public String getName() {
    return "Laboratory Results Report";
  }

  @Override
  public String getDescription() {
    return "Displaying of the laboratory results";
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
        "LABADULTS",
        Mapped.mapStraightThrough(labResultsDataset.constructLabResultsForAdultsDataset()));
    reportDefinition.addDataSetDefinition(
        "LABCHILDREN",
        Mapped.mapStraightThrough(labResultsDataset.constructLabResultsForChildrenDataset()));
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
              reportDefinition, "labresults.xls", "LAB RESULTS REPORT", getExcelDesignUuid(), null);
      Properties props = new Properties();
      props.put(
          "repeatingSections",
          "sheet:1,row:4,dataset:LABADULTS | sheet:2,row:4,dataset:LABCHILDREN");
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return Arrays.asList(reportDesign);
  }
}

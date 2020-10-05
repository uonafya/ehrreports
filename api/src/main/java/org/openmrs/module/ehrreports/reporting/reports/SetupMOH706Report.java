package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.datasets.Moh706Dataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupMOH706Report extends EhrDataExportManager {
  @Autowired private Moh706Dataset moh706Dataset;

  @Override
  public String getExcelDesignUuid() {
    return "bd832526-0473-11eb-b796-9f09eb6ccfd6";
  }

  @Override
  public String getUuid() {
    return "ccf4dc70-0473-11eb-b59b-7f341ba36e27";
  }

  @Override
  public String getName() {
    return "MOH 706 Report";
  }

  @Override
  public String getDescription() {
    return "Laboratory Test Summary Report Form";
  }

  @Override
  public ReportDefinition constructReportDefinition() {
    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setUuid(getUuid());
    reportDefinition.setName(getName());
    reportDefinition.addParameters(moh706Dataset.getParameters());
    reportDefinition.setDescription(getDescription());
    reportDefinition.addDataSetDefinition(
        "MOH706", Mapped.mapStraightThrough(moh706Dataset.constructMoh706Dataset()));
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
              "MOH_706.xls",
              "MOH 706 LAB TEST SUMMARY",
              getExcelDesignUuid(),
              null);
      Properties props = new Properties();
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return Arrays.asList(reportDesign);
  }
}

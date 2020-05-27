package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.datasets.Moh705bDataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupMOH705bReport extends EhrDataExportManager {
  @Autowired private Moh705bDataset moh705bDataset;

  @Override
  public String getExcelDesignUuid() {
    return "051e0f0c-9ff9-11ea-9d2a-87b34f3ac3dc";
  }

  @Override
  public String getUuid() {
    return "8a73dfa2-9ff8-11ea-9961-7f64bbc506a9";
  }

  @Override
  public String getName() {
    return "MOH 705 B Report";
  }

  @Override
  public String getDescription() {
    return "MOH 705 B  Workload Report";
  }

  @Override
  public ReportDefinition constructReportDefinition() {
    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setUuid(getUuid());
    reportDefinition.setName(getName());
    reportDefinition.setDescription(getDescription());
    reportDefinition.setParameters(moh705bDataset.getParameters());
    reportDefinition.addDataSetDefinition(
        "MOH705B", Mapped.mapStraightThrough(moh705bDataset.constructMoh705bDataset()));
    reportDefinition.addDataSetDefinition(
        "B", Mapped.mapStraightThrough(moh705bDataset.constructCustomDataset()));
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
              reportDefinition, "MOH_705b.xls", "MOH 705 B REPORT", getExcelDesignUuid(), null);
      Properties props = new Properties();
      props.put("repeatingSections", "sheet:1,row:5,dataset:MOH705B");
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return Arrays.asList(reportDesign);
  }
}

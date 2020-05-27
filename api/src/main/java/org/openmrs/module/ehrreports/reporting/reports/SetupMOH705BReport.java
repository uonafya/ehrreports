package org.openmrs.module.ehrreports.reporting.reports;

import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.reporting.report.definition.ReportDefinition;

public class SetupMOH705BReport extends EhrDataExportManager {
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
    return reportDefinition;
  }

  @Override
  public String getVersion() {
    return "1.0-SNAPSHOT";
  }
}

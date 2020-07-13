package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.cohorts.GenericCohortQueries;
import org.openmrs.module.ehrreports.reporting.library.datasets.Moh705aDataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupMOH705aReport extends EhrDataExportManager {

  @Autowired private Moh705aDataset moh705Dataset;

  @Autowired private GenericCohortQueries genericCohortQueries;

  @Override
  public String getUuid() {
    return "8e6c82d4-8f73-11ea-b22a-df41ade62345";
  }

  @Override
  public String getName() {
    return "MOH 705 A Report";
  }

  @Override
  public String getDescription() {
    return "MOH 705 A  Workload Report";
  }

  @Override
  public String getVersion() {
    return "1.0-SNAPSHOT";
  }

  @Override
  public String getExcelDesignUuid() {
    return "a09387b4-8f73-11ea-8aa4-570ef4b78b59";
  }

  @Override
  public ReportDefinition constructReportDefinition() {
    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setUuid(getUuid());
    reportDefinition.setName(getName());
    reportDefinition.setDescription(getDescription());
    reportDefinition.setParameters(moh705Dataset.getParameters());
    // tie the dataset here, you can add more than one data set definition
    reportDefinition.addDataSetDefinition(
        "MOH705A", Mapped.mapStraightThrough(moh705Dataset.constructMoh705aDataset()));
    reportDefinition.addDataSetDefinition(
        "C", Mapped.mapStraightThrough(moh705Dataset.constructCustomDataset()));
    reportDefinition.setBaseCohortDefinition(
        EhrReportUtils.map(
            genericCohortQueries.getBaseCohort(),
            "startDate=${startDate-1d},endDate=${endDate+1d}"));
    return reportDefinition;
  }

  @Override
  public List<ReportDesign> constructReportDesigns(ReportDefinition reportDefinition) {
    ReportDesign reportDesign = null;
    try {
      reportDesign =
          createXlsReportDesign(
              reportDefinition, "MOH_705a.xls", "MOH 705 A REPORT", getExcelDesignUuid(), null);
      Properties props = new Properties();
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return Arrays.asList(reportDesign);
  }
}

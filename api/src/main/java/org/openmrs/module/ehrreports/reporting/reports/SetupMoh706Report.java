package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.cohorts.GenericCohortQueries;
import org.openmrs.module.ehrreports.reporting.library.datasets.Moh706Dataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.ReportingException;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupMoh706Report extends EhrDataExportManager {

  @Autowired private Moh706Dataset moh706Dataset;

  @Autowired private GenericCohortQueries genericCohortQueries;

  @Override
  public String getExcelDesignUuid() {
    return "565f368c-d24b-11ea-8138-5382c7570834";
  }

  @Override
  public String getUuid() {
    return "7afbd112-d24b-11ea-bdd2-b7fa7a8ce199";
  }

  @Override
  public String getName() {
    return "MOH 706 Report";
  }

  @Override
  public String getDescription() {
    return "Monthly laboratory workload report - MOH 706";
  }

  @Override
  public ReportDefinition constructReportDefinition() {
    ReportDefinition rd = new ReportDefinition();
    rd.setUuid(getUuid());
    rd.setName(getName());
    rd.setDescription(getDescription());
    rd.addDataSetDefinition("A", Mapped.mapStraightThrough(moh706Dataset.constructMoh706Dataset()));
    rd.addDataSetDefinition("C", Mapped.mapStraightThrough(moh706Dataset.constructCustomDataset()));
    rd.equals(
        EhrReportUtils.map(
            genericCohortQueries.getBaseCohort(),
            "startDate=${startDate-1d},endDate=${endDate+1d}"));
    return rd;
  }

  @Override
  public List<ReportDesign> constructReportDesigns(ReportDefinition reportDefinition) {
    ReportDesign reportDesign = null;
    try {
      reportDesign =
          createXlsReportDesign(
              reportDefinition, "MOH_706.xls", "MOH706-Report", getExcelDesignUuid(), null);
      Properties props = new Properties();
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new ReportingException(e.toString());
    }

    return Arrays.asList(reportDesign);
  }

  @Override
  public String getVersion() {
    return "1.0-SNAPSHOT";
  }
}

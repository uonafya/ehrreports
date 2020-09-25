package org.openmrs.module.ehrreports.reporting.reports;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openmrs.module.ehrreports.reporting.library.datasets.SpecialClinicDataset;
import org.openmrs.module.ehrreports.reporting.reports.manager.EhrDataExportManager;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupSpecialClinicReport extends EhrDataExportManager {

  @Autowired private SpecialClinicDataset specialClinicDataset;

  @Override
  public String getExcelDesignUuid() {
    return "2003e626-ff34-11ea-bde9-3f3e721e9d38";
  }

  @Override
  public String getUuid() {
    return "2ea1326a-ff34-11ea-8c24-1b9dcce8ff38";
  }

  @Override
  public String getName() {
    return "Special Clinic Report";
  }

  @Override
  public String getDescription() {
    return "Report disaggreagted per the special clinics";
  }

  @Override
  public ReportDefinition constructReportDefinition() {
    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setUuid(getUuid());
    reportDefinition.setName(getName());
    reportDefinition.setDescription(getDescription());
    reportDefinition.setParameters(specialClinicDataset.getParameters());
    // tie the dataset here, you can add more than one data set definition
    reportDefinition.addDataSetDefinition(
        "SP", Mapped.mapStraightThrough(specialClinicDataset.getSpecialClinic()));
    return reportDefinition;
  }

  @Override
  public String getVersion() {
    return "1.0.0-SNAPSHOT";
  }

  @Override
  public List<ReportDesign> constructReportDesigns(ReportDefinition reportDefinition) {
    ReportDesign reportDesign = null;
    try {
      reportDesign =
          createXlsReportDesign(
              reportDefinition, "special_clinic.xls", "SPECIAL CLINIC", getExcelDesignUuid(), null);
      Properties props = new Properties();
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return Arrays.asList(reportDesign);
  }
}

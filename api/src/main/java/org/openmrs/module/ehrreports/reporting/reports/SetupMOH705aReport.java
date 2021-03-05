package org.openmrs.module.ehrreports.reporting.reports;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.kenyacore.report.ReportDescriptor;
import org.openmrs.module.kenyacore.report.builder.AbstractReportBuilder;
import org.openmrs.module.kenyacore.report.builder.Builds;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.stereotype.Component;

@Component
@Builds({"ehrreports.common.715a"})
public class SetupMOH705aReport extends AbstractReportBuilder {

  @Override
  protected List<Parameter> getParameters(ReportDescriptor reportDescriptor) {
    return Arrays.asList(
        new Parameter("startDate", "Start Date", Date.class),
        new Parameter("endDate", "End Date", Date.class));
  }

  @Override
  protected List<Mapped<DataSetDefinition>> buildDataSets(
      ReportDescriptor reportDescriptor, ReportDefinition reportDefinition) {
    return Arrays.asList(
        EhrReportUtils.map(getMoh715aReportDataset(), "startDate=${startDate},endDate=${endDate}"));
  }

  private DataSetDefinition getMoh715aReportDataset() {
    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    dsd.setName("MOH715A");
    dsd.setDescription("MOH 715 A");
    dsd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    dsd.addParameter(new Parameter("endDate", "End Date", Date.class));

    String indParams = "startDate=${startDate},endDate=${endDate}";

    return dsd;
  }
}

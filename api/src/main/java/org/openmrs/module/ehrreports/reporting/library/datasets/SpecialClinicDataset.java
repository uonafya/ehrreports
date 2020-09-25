package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.reporting.library.indicators.SpecialClinicIndicators;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialClinicDataset extends BaseDataSet {
  @Autowired private SpecialClinicIndicators indicators;

  public DataSetDefinition getSpecialClinic() {
    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    dsd.setName("Special clinic");
    dsd.addColumn(
        "T1",
        "Total values",
        EhrReportUtils.map(
            indicators.getSpecialClinic(), "startDate=${startDate},endDate=${endDate}"),
        "");
    return dsd;
  }
}

package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.library.indicators.EhrGeneralIndicator;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh706Dataset extends BaseDataSet {

  @Autowired private EhrCommonDimension ehrCommonDimension;

  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }

  public DataSetDefinition constructMoh706Dataset() {
    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();

    return dsd;
  }
}

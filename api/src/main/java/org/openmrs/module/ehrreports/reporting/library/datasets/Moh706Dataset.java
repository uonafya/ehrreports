package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.reporting.library.dimensions.AgeDimensionCohortInterface;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.library.indicators.EhrGeneralIndicator;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Moh706Dataset extends BaseDataSet {

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  @Autowired private EhrCommonDimension ehrCommonDimension;

  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  public DataSetDefinition constructMoh706Dataset() {
    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    String mappings = "startDate=${startDate},endDate=${endDate}";
    dsd.setName("MOH 706 Data Set");
    dsd.addParameters(getParameters());
    dsd.addDimension(
        "age",
        EhrReportUtils.map(ehrCommonDimension.age(ageDimensionCohort), "effectiveDate=${endDate}"));
    return dsd;
  }
}

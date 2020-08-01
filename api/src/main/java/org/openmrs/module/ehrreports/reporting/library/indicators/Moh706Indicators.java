package org.openmrs.module.ehrreports.reporting.library.indicators;

import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.cohorts.CommonLibrary;
import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh706CohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh706Indicators {
  @Autowired private Moh706CohortQueries moh706CohortQueries;
  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;
  @Autowired private CommonLibrary commonLibrary;
  @Autowired private OutpatientMetadata outpatientMetadata;

  public CohortIndicator getTyphoidTests() {
    return ehrGeneralIndicator.getIndicator(
        "Typhoid tests",
        EhrReportUtils.map(
            moh706CohortQueries.getAllTyphoidTests(), "startDate=${startDate},endDate=${endDate}"));
  }
}

package org.openmrs.module.ehrreports.reporting.library.indicators;

import org.openmrs.module.ehrreports.reporting.library.cohorts.special_clinic.SpecialClinicCohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialClinicIndicators {
  @Autowired private SpecialClinicCohortQueries queries;
  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  public CohortIndicator getSpecialClinic(int ans) {
    return ehrGeneralIndicator.getIndicator(
        "Special clinic indicator",
        EhrReportUtils.map(
            queries.getAllSpecialClinicPatients(ans), "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getTotalVisits(int ans) {
    return ehrGeneralIndicator.getIndicator(
        "Total visits indicator",
        EhrReportUtils.map(queries.getAllVisits(ans), "startDate=${startDate},endDate=${endDate}"));
  }
}

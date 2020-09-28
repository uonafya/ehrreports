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
    CohortIndicator special_clinic_indicator =
        ehrGeneralIndicator.getIndicator(
            "Special clinic indicator",
            EhrReportUtils.map(
                queries.getAllSpecialClinicPatients(ans),
                "startDate=${startDate},endDate=${endDate}"));
    return special_clinic_indicator;
  }

  public CohortIndicator getTotalVisits() {
    CohortIndicator totalVisits =
        ehrGeneralIndicator.getIndicator(
            "Total visits indicator",
            EhrReportUtils.map(
                queries.getAllVisits(), "startDate=${startDate},endDate=${endDate}"));
    return totalVisits;
  }
}

/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ehrreports.reporting.library.indicators;

import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh705aCohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aIndicators {
  @Autowired private Moh705aCohortQueries moh705aCohortQueries;

  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  /**
   * Get patients who are adults and have diagnosis other than the ones listed and classified
   *
   * @return CohortIndicator
   */
  public CohortIndicator getMoh705aPatientsHavingDiagnosisOtherThanTheOnesListed() {
    return ehrGeneralIndicator.getIndicator(
        "MOH705A - OTHER",
        EhrReportUtils.map(
            moh705aCohortQueries.getAllDiseasesExceptThoseClassifiedMoh705A(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  /**
   * Get patients who have diarrhoea during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingDiarrhoea() {
    return ehrGeneralIndicator.getIndicator(
        "Diarrhoea",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDiarrhoea(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  /**
   * Get patients who have Tuberculosis during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingTuberculosis() {
    return ehrGeneralIndicator.getIndicator(
        "Tuberculosis",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingTuberculosis(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  /**
   * Get patients who have Cholera during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingCholera() {
    return ehrGeneralIndicator.getIndicator(
        "Cholera",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingCholera(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  /**
   * Get patients who have Dyscentery during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingDycentery() {
    return ehrGeneralIndicator.getIndicator(
        "Cholera",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDysentery(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  /**
   * Get patients who have Meningococcal Infections during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsMeningococcalMeningitis() {
    return ehrGeneralIndicator.getIndicator(
        "Cholera",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingMeningococcalInfections(),
            "startDate=${startDate},endDate=${endDate}"));
  }
}

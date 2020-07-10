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
   * Get patients who have Dysentery during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingDysentery() {
    return ehrGeneralIndicator.getIndicator(
        "Dysentery",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDysentery(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Dysentery during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingMeningococcalInfctions() {
    return ehrGeneralIndicator.getIndicator(
        "Meningococcal",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingMeningococcalInfections(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingTonsillitis() {
    return ehrGeneralIndicator.getIndicator(
        "Tonsillitis",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingTonsillitis(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingPneumonia() {
    return ehrGeneralIndicator.getIndicator(
        "Pneumonia",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingPneumonia(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingOtherDiseaseOfRespiratorySystem() {
    return ehrGeneralIndicator.getIndicator(
        "Other Disease of Respiratory System",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherDiseaseOfRespiratory(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingMentalDisorders() {
    return ehrGeneralIndicator.getIndicator(
        "Mental Disorders",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingMentalDisorders(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingDentalDisorders() {
    return ehrGeneralIndicator.getIndicator(
        "Dental Disorders",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDentalDisorders(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingDiseaseOfTheSkin() {
    return ehrGeneralIndicator.getIndicator(
        "Dental Disorders",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDiseaseOfTheSkin(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingJiggersInfestation() {
    return ehrGeneralIndicator.getIndicator(
        "Jiggers Infestation",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingJiggersInfestation(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingChromosomalAbnomalities() {
    return ehrGeneralIndicator.getIndicator(
        "Chromosomal Abnomalities",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingChromosomalAbrnomalities(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingCongenitalAnomalies() {
    return ehrGeneralIndicator.getIndicator(
        "Congenital Anomalies",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingCongenitalAnomalies(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingPoisoning() {
    return ehrGeneralIndicator.getIndicator(
        "Poisoning",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingPoisoning(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingRoadTrafficInjuries() {
    return ehrGeneralIndicator.getIndicator(
        "Road Traffic Injuries",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingRoadTrafficInjuries(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingOtherInjuries() {
    return ehrGeneralIndicator.getIndicator(
        "Other Injuries",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherInjuries(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingSexualAssault() {
    return ehrGeneralIndicator.getIndicator(
        "Sexual Assault",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingSexualAssault(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingBurns() {
    return ehrGeneralIndicator.getIndicator(
        "Burns",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingBurns(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingSnakeBites() {
    return ehrGeneralIndicator.getIndicator(
        "Snake Bites",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingSnakeBites(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingDogBites() {
    return ehrGeneralIndicator.getIndicator(
        "Dog Bites",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDogBites(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingOtherBites() {
    return ehrGeneralIndicator.getIndicator(
        "Other Bites",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherBites(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  public CohortIndicator getPatientsHavingDiabetes() {
    return ehrGeneralIndicator.getIndicator(
        "Other Bites",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDiabetes(),
            "startDate=${startDate},endDate=${endDate}"));
  }



}

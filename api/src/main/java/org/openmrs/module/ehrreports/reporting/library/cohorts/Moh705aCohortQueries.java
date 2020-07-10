/*
 * The contents of this file are subject to the OpenMRS Public License Version
 * 1.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.ehrreports.reporting.library.cohorts;

import java.util.Date;
import java.util.List;
import org.openmrs.module.ehrreports.metadata.DiagnosisMetadata;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.queries.moh705.Moh705Queries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CompositionCohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aCohortQueries {
  @Autowired private OutpatientMetadata outpatientMetadata;
  @Autowired private DiagnosisMetadata diagnosisMetadata;
  @Autowired private Moh717CohortQueries moh717CohortQueries;

  /**
   * Get adult patients who have given diagnosis - MOH705A
   *
   * @return @{@link org.openmrs.module.reporting.cohort.definition.CohortDefinition}
   */
  public CohortDefinition getAdultPatientsWhoHaveDiagnosis(List<Integer> list) {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Get adult patients who have diagnosis based on list of concepts");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh705Queries.getAdultPatientsWhoMatchDiagnosisBasedOnConcepts(
            outpatientMetadata.getDiagnosisConceptClass().getConceptClassId(), list));
    return cd;
  }

  /**
   * Get adults patients having any diagnosis specified in the observation collected
   *
   * @return @{@link CohortDefinition} of patient ids of adult patients
   */
  public CohortDefinition getAdultsPatientsWithAllDiagnosisRecorded() {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Get adult patients who have diagnosis - all");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh705Queries.getAdultsPatientsWhoMatchDiagnosisAll(
            outpatientMetadata.getDiagnosisConceptClass().getConceptClassId()));
    return cd;
  }

  /**
   * Get patients who have diahorea during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDiarrhoea() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getDiarrhoeaConceptList());
  }
  /**
   * Get patients who have Tuberculosis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingTuberculosis() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getTuberculosisConceptList());
  }

  /**
   * Get patients who have Cholera during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingCholera() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getCholeraList());
  }

  /**
   * Get patients who have MenongococcalInfectionsList during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMeningococcalInfections() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getMenongococcalInfectionsList());
  }

  /**
   * Get patients who have MenongococcalInfectionsList during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDysentery() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getDysenteryList());
  }
  /**
   * Get patients who have Pneumonia during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingPneumonia() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getPneumoniaConceptList());
  }
  /**
   * Get patients who have Tonsillitis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingTonsillitis() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getTonsillitisConceptList());
  }
  /**
   * Get patients who have Other Disease Of Respiratory during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherDiseaseOfRespiratory() {
    return getAdultPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getOtherDiseaseOfRespiratorySystemConceptList());
  }
  /**
   * Get patients who have Mental Disorders during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMentalDisorders() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getMentalDisordersConceptList());
  }
  /**
   * Get patients who have Dental Disorders during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDentalDisorders() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getDentalDisordersConceptList());
  }
  /**
   * Get patients who have Dental Disorders during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingJiggersInfestation() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getJiggersInfestationConceptList());
  }
  /**
   * Get patients who have Disease Of The Skin during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDiseaseOfTheSkin() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getDiseaseOfTheSkinConceptList());
  }
  /**
   * Get patients who have Chromosomal Abrnomalities during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingChromosomalAbrnomalities() {
    return getAdultPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getChromosomalAbnormalitiesConceptList());
  }
  /**
   * Get patients who have Congenital Anomalies during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingCongenitalAnomalies() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getCongenitalAnomaliesConceptList());
  }
  /**
   * Get patients who have had poisoning during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingPoisoning() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getPoisoningConceptList());
  }
  /**
   * Get patients who have had RTA during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingRoadTrafficInjuries() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getRoadTrafficInjuriesConceptList());
  }

  /**
   * Get patients who have had Other Injuries during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherInjuries() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getRoadOtherInjuriesConceptList());
  }

  /**
   * Get patients who have had Sexual Assault during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingSexualAssault() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getSexualAssaultConceptList());
  }
  /**
   * Get patients who have had Burns during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingBurns() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getBurnsConceptList());
  }
  /**
   * Get patients who have had Snake Bites during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingSnakeBites() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getSnakeBitesConceptList());
  }
  /**
   * Get patients who have had Snake Bites during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDogBites() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getDogBitesConceptList());
  }
  /**
   * Get patients who have had Other Bites during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherBites() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getOtherBitesConceptList());
  }
  /**
   * Get patients who have had Diabetes during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDiabetes() {
    return getAdultPatientsWhoHaveDiagnosis(diagnosisMetadata.getDiabetesConceptList());
  }

  /**
   * All other diseases that are taken in the facility over a period of time
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getAllDiseasesExceptThoseClassifiedMoh705A() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other adults diagnosis other than the ones classified");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "ALL",
        EhrReportUtils.map(
            getAdultsPatientsWithAllDiagnosisRecorded(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "1",
        EhrReportUtils.map(
            getPatientsHavingDiarrhoea(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "2",
        EhrReportUtils.map(
            getPatientsHavingTuberculosis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "3",
        EhrReportUtils.map(
            getPatientsHavingDysentery(), "startDate=${startDate},endDate=${endDate}"));

    cd.addSearch(
        "4",
        EhrReportUtils.map(
            getPatientsHavingCholera(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "5",
        EhrReportUtils.map(
            getPatientsHavingMeningococcalInfections(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "27",
        EhrReportUtils.map(
            getPatientsHavingTonsillitis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "28",
        EhrReportUtils.map(
            getPatientsHavingPneumonia(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "29",
        EhrReportUtils.map(
            getPatientsHavingOtherDiseaseOfRespiratory(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "30",
        EhrReportUtils.map(
            getPatientsHavingMentalDisorders(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "31",
        EhrReportUtils.map(
            getPatientsHavingDentalDisorders(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "32",
        EhrReportUtils.map(
            getPatientsHavingJiggersInfestation(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "33",
        EhrReportUtils.map(
            getPatientsHavingDiseaseOfTheSkin(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "34",
        EhrReportUtils.map(
            getPatientsHavingChromosomalAbrnomalities(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "35",
        EhrReportUtils.map(
            getPatientsHavingCongenitalAnomalies(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "36",
        EhrReportUtils.map(
            getPatientsHavingPoisoning(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "37",
        EhrReportUtils.map(
            getPatientsHavingRoadTrafficInjuries(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "38",
        EhrReportUtils.map(
            getPatientsHavingOtherInjuries(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "39",
        EhrReportUtils.map(
            getPatientsHavingSexualAssault(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "40",
        EhrReportUtils.map(getPatientsHavingBurns(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "41",
        EhrReportUtils.map(
            getPatientsHavingSnakeBites(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "42",
        EhrReportUtils.map(
            getPatientsHavingDogBites(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "43",
        EhrReportUtils.map(
            getPatientsHavingOtherBites(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "44",
        EhrReportUtils.map(
            getPatientsHavingDiabetes(), "startDate=${startDate},endDate=${endDate}"));

    cd.setCompositionString(
        "ALL AND NOT (1 OR 2 OR 3 OR 4 OR 5 OR 27 OR 28 OR 29 OR 30 OR 31 OR 32 OR 33 OR 34 OR 35 OR 36 OR 37 OR 38 OR 39 OR 40 OR 41 OR 42 OR 43 OR 44)");
    return cd;
  }
  /**
   * Get number of first/revisit attendancies column 64
   *
   * @return @CohortDefinition
   */
  public CohortDefinition getNewAndRevisitPatients(EhrReportConstants.OccurenceStates state) {
    return moh717CohortQueries.getPatientStates(state);
  }
  /** Get */
}

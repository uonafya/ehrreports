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
import org.openmrs.Concept;
import org.openmrs.module.ehrreports.metadata.EhrDiagnosisMetadata;
import org.openmrs.module.ehrreports.metadata.EhrOutpatientMetadata;
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
  @Autowired private EhrOutpatientMetadata outpatientMetadata;
  @Autowired private EhrDiagnosisMetadata diagnosisMetadata;
  @Autowired private Moh717CohortQueries moh717CohortQueries;
  @Autowired private CommonLibrary commonLibrary;
  @Autowired private AgeCohortQueries ageCohortQueries;

  /**
   * Get adult patients who have given diagnosis - MOH705A
   *
   * @return @{@link org.openmrs.module.reporting.cohort.definition.CohortDefinition}
   */
  public CohortDefinition getChildrenPatientsWhoHaveDiagnosis(List<Integer> list) {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Get children patients who have diagnosis based on list of concepts");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh705Queries.getChildrenPatientsWhoMatchDiagnosisBasedOnConcepts(
            outpatientMetadata.getDiagnosisConceptClass().getConceptClassId(), list));
    return cd;
  }

  /**
   * Get children patients having any diagnosis specified in the observation collected
   *
   * @return @{@link CohortDefinition} of patient ids of adult patients
   */
  public CohortDefinition getchildrenPatientsWithAllDiagnosisRecorded() {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Get children patients who have diagnosis - all");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh705Queries.getChildrenPatientsWhoMatchDiagnosisAll(
            outpatientMetadata.getDiagnosisConceptClass().getConceptClassId()));
    return cd;
  }

  /**
   * Get patients who have diahorea during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDiarrhoea() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDiarrhoeaConceptList());
  }

  /**
   * Get patients who have Tuberculosis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingTuberculosis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getTuberculosisConceptList());
  }

  /**
   * Get patients who have Cholera during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingCholera() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getCholeraList());
  }

  /**
   * Get patients who have MenongococcalInfectionsList during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMeningococcalInfections() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getMenongococcalInfectionsList());
  }

  /**
   * Get patients who have Other Meningitis List during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherMeningitis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getOtherMeningitisConceptList());
  }

  /**
   * Get patients who have Other Neonatorum Tetanus List during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingNeonatorumtTetanus() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getNeonatorumTetanusConceptList());
  }

  /**
   * Get patients who have Poliomyelitis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingPoliomyelitis() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getAcutePoliomyelitisConceptList());
  }

  /**
   * Get patients who have Chicken Pox during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingChickenPox() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getAcutePoliomyelitisConceptList());
  }

  /**
   * Get patients who have Measles during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMeasles() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getMeaslesConceptList());
  }

  /**
   * Get patients who have Hepatitis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingHepatitis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getHepatitisConceptList());
  }

  /**
   * Get patients who have Mumps during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMumps() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getMumpsConceptList());
  }

  /**
   * Get patients who have Fevers during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingFevers() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getFeversConceptList());
  }
  /**
   * Get patients who have Urinary Tract Infection during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingUrinaryTractInfection() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getUrinaryTractInfectionConceptList());
  }
  /**
   * Get patients who have Typhoid Fever during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingTyphoidFever() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getTyphoidFeverConceptList());
  }
  /**
   * Get patients who have Bilharzia during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingBilharzia() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getBilharziaConceptList());
  }
  /**
   * Get patients who have Intestinal worms during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingIntestinalWorms() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getIntestinalWormsConceptist());
  }
  /**
   * Get patients who have Malnutrition during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMalnutrition() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getMalnutritionConceptist());
  }
  /**
   * Get patients who have Anaemia during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingAnaemia() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getAnaemiaConceptList());
  }
  /**
   * Get patients who have Eye Infections during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingEyeInfections() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getEyeInfectionsConceptList());
  }
  /**
   * Get patients who have Other Eye Conditions during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherEyeConditions() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getOtherEyeConditionsConceptList());
  }
  /**
   * Get patients who have Ear Infections/conditions during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingEarInfections() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getEarInfectionsConceptList());
  }
  /**
   * Get patients who have Upper Respiratory Tract Infections during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingUpperRespiratoryTractInfections() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getUpperRespiratoryTractInfectionsConceptList());
  }
  /**
   * Get patients who have Asthma during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingAsthma() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getAsthmaConceptList());
  }

  /**
   * Get patients who have Dysentery during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDysentery() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDysenteryList());
  }

  /**
   * Get patients who have Pneumonia during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingPneumonia() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getPneumoniaConceptList());
  }

  /**
   * Get patients who have Tonsillitis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingTonsillitis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getTonsillitisConceptList());
  }

  /**
   * Get patients who have Other Disease Of Respiratory during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherDiseaseOfRespiratory() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getOtherDiseaseOfRespiratorySystemConceptList());
  }

  /**
   * Get patients who have Mental Disorders during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingMentalDisorders() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getMentalDisordersConceptList());
  }

  /**
   * Get patients who have Dental Disorders during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDentalDisorders() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDentalDisordersConceptList());
  }

  /**
   * Get patients who have Dental Disorders during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingJiggersInfestation() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getJiggersInfestationConceptList());
  }

  /**
   * Get patients who have Disease Of The Skin during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDiseaseOfTheSkin() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDiseaseOfTheSkinConceptList());
  }

  /**
   * Get patients who have Chromosomal Abrnomalities during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingChromosomalAbrnomalities() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getChromosomalAbnormalitiesConceptList());
  }

  /**
   * Get patients who have Congenital Anomalies during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingCongenitalAnomalies() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getCongenitalAnomaliesConceptList());
  }

  /**
   * Get patients who have had poisoning during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingPoisoning() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getPoisoningConceptList());
  }

  /**
   * Get patients who have had RTA during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingRoadTrafficInjuries() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getRoadTrafficInjuriesConceptList());
  }

  /**
   * Get patients who have had Other Injuries during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherInjuries() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getOtherInjuriesConceptList());
  }

  /**
   * Get patients who have had Sexual Assault during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingSexualAssault() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getSexualAssaultConceptList());
  }

  /**
   * Get patients who have had Burns during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingBurns() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getBurnsConceptList());
  }

  /**
   * Get patients who have had Snake Bites during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingSnakeBites() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getSnakeBitesConceptList());
  }

  /**
   * Get patients who have had Snake Bites during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDogBites() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDogBitesConceptList());
  }

  /**
   * Get patients who have had Other Bites during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherBites() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getOtherBitesConceptList());
  }

  /**
   * Get patients who have had Diabetes during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDiabetes() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDiabetesConceptList());
  }

  /**
   * Get patients who have had Epilepsy during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingEpilepsy() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getEpilepsyConceptList());
  }

  /**
   * Get patients who have had Epilepsy during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherConvulsiveDisorders() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getOtherConvulsiveDisordersConceptList());
  }

  /**
   * Get patients who have had Epilepsy during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingBrucellosis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getBrucellosisConceptList());
  }

  /**
   * Get patients who have had Epilepsy during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingRickets() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getRicketsConceptList());
  }

  /**
   * Get patients who have been Newly Diagnosed HIV during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingNewlyDiagnosedHiv() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getNewlyDiagnoseHivConceptList());
  }

  /**
   * Get patients who had Violence Related Injuries period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingCardiovascularCondition() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getCardiovascularConditionConceptList());
  }

  /**
   * Get patients who Had Violence Related Injuries during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingViolenceRelatedInjuries() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getViolenceRelatedInjuriesConceptList());
  }

  /**
   * Get patients who Had Cerebral Palsy during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingCerebralPalsy() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getCerebralPalsyConceptList());
  }

  /**
   * Get patients who Had Autism during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingAutism() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getAutismConceptList());
  }

  /**
   * Get patients who Had Other Central Narvous Sysytem Condition during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingOtherCentralNarvousSytemCondition() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getOtherCentralNarvousSytemConditionConceptList());
  }

  /**
   * Get patients who Had Tryponosomiasis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingTryponosomiasis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getTryponosomiasisConceptList());
  }

  /**
   * Get patients who Had Kalazar during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingKalazar() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getKalazarConceptList());
  }

  /**
   * Get patients who Had Dracunculosis during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDracunculosis() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getDracunculosisConceptList());
  }

  /**
   * Get patients who Had Yellow Fever during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingYellowFever() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getYellowFeverConceptList());
  }

  /**
   * Get patients who Had Viral Haemorrhagic Fever during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingViralHaemorrhagicFever() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getViralHaemorrhagicFeverConceptList());
  }

  /**
   * Get patients who Had Plague during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingPlague() {
    return getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getPlagueConceptList());
  }

  /**
   * Get patients who Had Deathts Due To Road Traffic Injuries during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingDeathtsDueToRoadTrafficInjuries() {
    return getChildrenPatientsWhoHaveDiagnosis(
        diagnosisMetadata.getDeathtsDueToRoadTrafficInjuriesConceptList());
  }

  /**
   * Get first 10 diseases to exclude form the main query of other diseases
   *
   * @return @{@link CohortDefinition}
   */
  private CohortDefinition get1st10DiseasesToExcludeFromMainQuery() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified first 10");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
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
        "6",
        EhrReportUtils.map(
            getPatientsHavingOtherMeningitis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "7",
        EhrReportUtils.map(
            getPatientsHavingNeonatorumtTetanus(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "8",
        EhrReportUtils.map(
            getPatientsHavingPoliomyelitis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "9",
        EhrReportUtils.map(
            getPatientsHavingChickenPox(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "10",
        EhrReportUtils.map(
            getPatientsHavingMeasles(), "startDate=${startDate},endDate=${endDate}"));
    cd.setCompositionString("1 OR 2 OR 3 OR 4 OR 5 OR 6 OR 7 OR 8 OR 9 OR 10");
    return cd;
  }

  /**
   * Get the second 10 diseases to exclude from the main query
   *
   * @return @{@link CohortDefinition}
   */
  private CohortDefinition get2nd10DiseasesToExcludeFromMainQuery() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified second 10");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "11",
        EhrReportUtils.map(
            getPatientsHavingHepatitis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "12",
        EhrReportUtils.map(getPatientsHavingMumps(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "13",
        EhrReportUtils.map(getPatientsHavingFevers(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "16",
        EhrReportUtils.map(
            getPatientsHavingUrinaryTractInfection(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "17",
        EhrReportUtils.map(
            getPatientsHavingTyphoidFever(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "18",
        EhrReportUtils.map(
            getPatientsHavingBilharzia(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "19",
        EhrReportUtils.map(
            getPatientsHavingIntestinalWorms(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "20",
        EhrReportUtils.map(
            getPatientsHavingMalnutrition(), "startDate=${startDate},endDate=${endDate}"));
    cd.setCompositionString("11 OR 12 OR 13 OR 16 OR 17 OR 18 OR 19 OR 20");
    return cd;
  }

  /**
   * Get the third 10 disease to exclude from the main query
   *
   * @return @{@link CohortDefinition}
   */
  private CohortDefinition get3rd10DiseasesToExcludeFromMainQuery() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified third 10");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "21",
        EhrReportUtils.map(
            getPatientsHavingAnaemia(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "22",
        EhrReportUtils.map(
            getPatientsHavingEyeInfections(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "23",
        EhrReportUtils.map(
            getPatientsHavingOtherEyeConditions(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "24",
        EhrReportUtils.map(
            getPatientsHavingUpperRespiratoryTractInfections(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "25",
        EhrReportUtils.map(
            getPatientsHavingEarInfections(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "26",
        EhrReportUtils.map(getPatientsHavingAsthma(), "startDate=${startDate},endDate=${endDate}"));
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
    cd.setCompositionString("21 OR 22 OR 23 OR 24 OR 25 OR 26 OR 27 OR 28 OR 29 OR 30");
    return cd;
  }

  /**
   * Get 4th 10 diseases to be excluded from the main query
   *
   * @retrun @{@link CohortDefinition}
   */
  private CohortDefinition get4th10DiseasesToExcludeFromMainQuery() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified 4th 10 ");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
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

    cd.setCompositionString("31 OR 32 OR 33 OR 34 OR 35 OR 36 OR 37 OR 38 OR 39 OR 40");
    return cd;
  }

  /**
   * Get 5th 10 diseases to exclude from the main query
   *
   * @return @{@link CohortDefinition}
   */
  private CohortDefinition get5th10DiseasesToExcludeFromMainQuery() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified 5th 10");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
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
    cd.addSearch(
        "45",
        EhrReportUtils.map(
            getPatientsHavingEpilepsy(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "46",
        EhrReportUtils.map(
            getPatientsHavingOtherConvulsiveDisorders(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "47",
        EhrReportUtils.map(
            getPatientsHavingNewlyDiagnosedHiv(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "48",
        EhrReportUtils.map(
            getPatientsHavingBrucellosis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "49",
        EhrReportUtils.map(
            getPatientsHavingRickets(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "50",
        EhrReportUtils.map(
            getPatientsHavingCardiovascularCondition(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.setCompositionString("41 OR 42 OR 43 OR 44 OR 45 OR 46 OR 47 OR 48 OR 49 OR 50");
    return cd;
  }

  /**
   * Get 6th 10 diseases to be excluded from the main query
   *
   * @return @{@link CohortDefinition}
   */
  private CohortDefinition get6th10DiseasesToExcludeFromMainQuery() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified the rest");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "51",
        EhrReportUtils.map(
            getPatientsHavingViolenceRelatedInjuries(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "52",
        EhrReportUtils.map(
            getPatientsHavingCerebralPalsy(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "53",
        EhrReportUtils.map(getPatientsHavingAutism(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "54",
        EhrReportUtils.map(
            getPatientsHavingOtherCentralNarvousSytemCondition(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "55",
        EhrReportUtils.map(
            getPatientsHavingTryponosomiasis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "56",
        EhrReportUtils.map(
            getPatientsHavingKalazar(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "57",
        EhrReportUtils.map(
            getPatientsHavingDracunculosis(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "58",
        EhrReportUtils.map(
            getPatientsHavingYellowFever(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "59",
        EhrReportUtils.map(
            getPatientsHavingViralHaemorrhagicFever(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "60",
        EhrReportUtils.map(getPatientsHavingPlague(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "61",
        EhrReportUtils.map(
            getPatientsHavingDeathtsDueToRoadTrafficInjuries(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.setCompositionString("51 OR 52 OR 53 OR 54 OR 55 OR 56 OR 57 OR 58 OR 59 OR 60 OR 61");
    return cd;
  }

  /**
   * All other diseases that are taken in the facility over a period of time
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getAllDiseasesExceptThoseClassifiedMoh705A() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get other children diagnosis other than the ones classified");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "ALL",
        EhrReportUtils.map(
            getchildrenPatientsWithAllDiagnosisRecorded(),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "first10",
        EhrReportUtils.map(
            get1st10DiseasesToExcludeFromMainQuery(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "second10",
        EhrReportUtils.map(
            get2nd10DiseasesToExcludeFromMainQuery(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "third10",
        EhrReportUtils.map(
            get3rd10DiseasesToExcludeFromMainQuery(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "fourth10",
        EhrReportUtils.map(
            get4th10DiseasesToExcludeFromMainQuery(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "fifth10",
        EhrReportUtils.map(
            get5th10DiseasesToExcludeFromMainQuery(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "theRest",
        EhrReportUtils.map(
            get6th10DiseasesToExcludeFromMainQuery(), "startDate=${startDate},endDate=${endDate}"));
    cd.setCompositionString(
        "ALL AND NOT (first10 OR second10 OR third10 OR fourth10 OR fifth10 OR theRest)");

    return cd;
  }

  /**
   * Get number of first/revisit attendancies column 64
   *
   * @return @CohortDefinition
   */
  public CohortDefinition getNewAndRevisitPatients(EhrReportConstants.OccurenceStates state) {
    return moh717CohortQueries.getRevisitPatientStates(state);
  }
  /**
   * Get patient shaving provisional malaria
   *
   * @return @CohortDefinition
   */
  public CohortDefinition getMalariaCases(Concept concept) {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get patients with provisional malaria cases");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "malaria",
        EhrReportUtils.map(
            getChildrenPatientsWhoHaveDiagnosis(diagnosisMetadata.getMalariaConceptList()),
            "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "status",
        EhrReportUtils.map(
            commonLibrary.hasObs(concept), "onOrAfter=${startDate},onOrBefore=${endDate}"));
    cd.setCompositionString("malaria AND status");
    return cd;
  }

  /**
   * Get new and reattendancies of children
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getNewAndRevisitsOfChildren(EhrReportConstants.OccurenceStates state) {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Get patients with new and reattendances for children");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "age",
        EhrReportUtils.map(
            ageCohortQueries.createXtoYAgeCohort("age", null, 4), "effectiveDate=${endDate}"));
    cd.addSearch(
        "state", EhrReportUtils.map(getNewAndRevisitPatients(state), "onOrBefore=${endDate}"));
    cd.setCompositionString("state AND age");
    return cd;
  }

  /**
   * Get patients with referals based on age
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getChildrenPatientsReferredToFacility() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Children referred to other health facilities");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "age",
        EhrReportUtils.map(
            ageCohortQueries.createXtoYAgeCohort("age", null, 4), "effectiveDate=${endDate}"));
    cd.addSearch(
        "obs",
        EhrReportUtils.map(
            commonLibrary.hasObs(outpatientMetadata.getPatientReferredFrom()),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    cd.setCompositionString("obs AND age");
    return cd;
  }

  /**
   * Get patients with referals to other health facilities based on age
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getChildrenPatientsReferredFromFacility() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("Children referred from other health facilities");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "age",
        EhrReportUtils.map(
            ageCohortQueries.createXtoYAgeCohort("age", null, 4), "effectiveDate=${endDate}"));
    cd.addSearch(
        "obs",
        EhrReportUtils.map(
            commonLibrary.hasObs(outpatientMetadata.getPatientReferredExternally()),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    cd.setCompositionString("obs AND age");
    return cd;
  }
}

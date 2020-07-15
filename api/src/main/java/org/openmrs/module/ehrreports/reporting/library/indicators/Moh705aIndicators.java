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

import org.openmrs.Concept;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.cohorts.CommonLibrary;
import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh705aCohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aIndicators {
  @Autowired private Moh705aCohortQueries moh705aCohortQueries;

  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  @Autowired private CommonLibrary commonLibrary;

  @Autowired private OutpatientMetadata outpatientMetadata;

  /**
   * Get patients who are children and have diagnosis other than the ones listed and classified
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
   * Get patients who are children and have new/revisit
   *
   * @return CohortIndicator
   */
  public CohortIndicator getNewAndRevisitPatients(EhrReportConstants.OccurenceStates state) {
    return ehrGeneralIndicator.getIndicator(
        "New or revisit patients for children",
        EhrReportUtils.map(
            moh705aCohortQueries.getNewAndRevisitsOfChildren(state), "endDate=${endDate}"));
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
  /**
   * Get patients who have other meningitis during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsOtherMeningitis() {
    return ehrGeneralIndicator.getIndicator(
        "Other Meningitis",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherMeningitis(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Neonatal tetanus during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingNeonatalTetanus() {
    return ehrGeneralIndicator.getIndicator(
        "Neonatal Tetanus",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingNeonatorumtTetanus(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Poliomyelitis(AFP) during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingPoliomyelitis() {
    return ehrGeneralIndicator.getIndicator(
        "Poliomyelitis(AFP) ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingPoliomyelitis(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Chicken Pox during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingChickenPox() {
    return ehrGeneralIndicator.getIndicator(
        "Chicken Pox ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingChickenPox(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Measles during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingMeasles() {
    return ehrGeneralIndicator.getIndicator(
        "Measles ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingMeasles(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Hepatitis during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingHepatitis() {
    return ehrGeneralIndicator.getIndicator(
        "Hepatitis ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingHepatitis(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Mumps during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingMumps() {
    return ehrGeneralIndicator.getIndicator(
        "Mumps ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingMumps(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Fevers during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingFevers() {
    return ehrGeneralIndicator.getIndicator(
        "Fevers ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingFevers(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Urinary Tract Infection during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingUrinaryTractInfection() {
    return ehrGeneralIndicator.getIndicator(
        "Urinary Tract Infection ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingUrinaryTractInfection(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Typhoid Fevers during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingTyphoidFever() {
    return ehrGeneralIndicator.getIndicator(
        "Typhoid fever ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingTyphoidFever(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Bilharzia during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingBilharzia() {
    return ehrGeneralIndicator.getIndicator(
        "Bilharzia ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingBilharzia(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Intestinal worms during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingIntestinalWorms() {
    return ehrGeneralIndicator.getIndicator(
        "Intestinal worms ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingIntestinalWorms(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have malnutrition during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingMalnutrition() {
    return ehrGeneralIndicator.getIndicator(
        "Malnutrition ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingMalnutrition(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Anaemia during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingAnaemia() {
    return ehrGeneralIndicator.getIndicator(
        "Anaemia ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingAnaemia(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Eye Infections during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingEyeInfections() {
    return ehrGeneralIndicator.getIndicator(
        "Eye Infections ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingEyeInfections(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Other Eye Conditions during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingOtherEyeConditions() {
    return ehrGeneralIndicator.getIndicator(
        "Other Eye conditions ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherEyeConditions(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Ear Infections/Conditions during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingEarInfections() {
    return ehrGeneralIndicator.getIndicator(
        "Ear Infections/Conditions ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingEarInfections(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have Upper Respiratory Tract Infections during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingUpperRespiratoryTractInfections() {
    return ehrGeneralIndicator.getIndicator(
        "Upper Respiratory Tract Infections ",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingUpperRespiratoryTractInfections(),
            "startDate=${startDate},endDate=${endDate}"));
  }
  /**
   * Get patients who have ASTHMA during the month
   *
   * @return @CohortIndicator
   */
  public CohortIndicator getPatientsHavingAsthma() {
    return ehrGeneralIndicator.getIndicator(
        "Asthma",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingAsthma(),
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

  public CohortIndicator getPatientsHavingEpilepsy() {
    return ehrGeneralIndicator.getIndicator(
        "Other Epilepsy",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingEpilepsy(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingDiabetes() {
    return ehrGeneralIndicator.getIndicator(
        "Patients having diabetes",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDiabetes(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingOtherConvulsiveDisorders() {
    return ehrGeneralIndicator.getIndicator(
        "Other Bites",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherConvulsiveDisorders(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingNewlyDiagnosedHiv() {
    return ehrGeneralIndicator.getIndicator(
        "Newly Diagnosed HIV",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingNewlyDiagnosedHiv(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingBrucellosis() {
    return ehrGeneralIndicator.getIndicator(
        "Brucellosis",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingBrucellosis(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingRickets() {
    return ehrGeneralIndicator.getIndicator(
        "Rickets",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingRickets(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingCardiovascularCondition() {
    return ehrGeneralIndicator.getIndicator(
        "Cardiovascular Condition",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingCardiovascularCondition(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingViolenceRelatedInjuries() {
    return ehrGeneralIndicator.getIndicator(
        "Violence Related Injuries",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingViolenceRelatedInjuries(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingCerebralPalsy() {
    return ehrGeneralIndicator.getIndicator(
        "Cerebral Palsy",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingCerebralPalsy(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingAutism() {
    return ehrGeneralIndicator.getIndicator(
        "Autism",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingAutism(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingOtherCentralNarvousSytemCondition() {
    return ehrGeneralIndicator.getIndicator(
        "Other Central Narvous System Condition",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingOtherCentralNarvousSytemCondition(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingTryponosomiasis() {
    return ehrGeneralIndicator.getIndicator(
        "Tryponosomiasis",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingTryponosomiasis(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingKalazar() {
    return ehrGeneralIndicator.getIndicator(
        "Kalazar(Leishmaniasis)",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingKalazar(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingDracunculosis() {
    return ehrGeneralIndicator.getIndicator(
        "Dracunculosis (Guinea Worm)",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDracunculosis(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingYellowFever() {
    return ehrGeneralIndicator.getIndicator(
        "Yellow Fever",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingYellowFever(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingViralHaemorrhagicFever() {
    return ehrGeneralIndicator.getIndicator(
        "Viral Haemorrhagic Fever",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingViralHaemorrhagicFever(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingPlague() {
    return ehrGeneralIndicator.getIndicator(
        "Plague",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingPlague(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsHavingDeathtsDueToRoadTrafficInjuries() {
    return ehrGeneralIndicator.getIndicator(
        "Deathts Due To Road Traffic Injuries",
        EhrReportUtils.map(
            moh705aCohortQueries.getPatientsHavingDeathtsDueToRoadTrafficInjuries(),
            "startDate=${startDate},endDate=${endDate}"));
  }

  public CohortIndicator getPatientsReferredToFacility() {
    return ehrGeneralIndicator.getIndicator(
        "Patients who are referred to this facility",
        EhrReportUtils.map(
            commonLibrary.hasObs(outpatientMetadata.getPatientReferredFrom()),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
  }

  public CohortIndicator getPatientsReferredToExternalFacilities() {
    return ehrGeneralIndicator.getIndicator(
        "Patients who are referred to external facility",
        EhrReportUtils.map(
            commonLibrary.hasObs(outpatientMetadata.getPatientReferredExternally()),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
  }

  public CohortIndicator getPatientsWithMalaria(Concept concept) {
    return ehrGeneralIndicator.getIndicator(
        "Patients who have malaria depending on status",
        EhrReportUtils.map(
            moh705aCohortQueries.getMalariaCases(concept),
            "startDate=${startDate},endDate=${endDate}"));
  }
}

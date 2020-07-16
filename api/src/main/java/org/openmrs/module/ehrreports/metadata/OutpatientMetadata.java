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
package org.openmrs.module.ehrreports.metadata;

import org.openmrs.Concept;
import org.openmrs.ConceptClass;
import org.openmrs.EncounterType;
import org.openmrs.Program;
import org.openmrs.api.context.Context;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.springframework.stereotype.Component;

@Component("outpatientMetadata")
public class OutpatientMetadata extends ProgramsMetadata {

  // encounter types
  // encounter type 1
  public EncounterType getAdultsInitialEncounterType() {
    return getEncounterType(EhrReportConstants.ADULTINITIAL_OUTPATIENT);
  }

  // encounter type 2
  public EncounterType getAdultReturnEncounterType() {
    return getEncounterType(EhrReportConstants.ADULTRETURN_OUTPATIENT);
  }

  // encounter type 3
  public EncounterType getPedsInitialEncounterType() {
    return getEncounterType(EhrReportConstants.PEDSINITIAL_OUTPATIENT);
  }

  // encounter type 4
  public EncounterType getPedsReturnEncounterType() {
    return getEncounterType(EhrReportConstants.PEDSRETURN_OUTPATIENT);
  }

  // encounter type 5
  public EncounterType getRegInitialEncounterType() {
    return getEncounterType(EhrReportConstants.REGINITIAL_OUTPATIENT);
  }

  // encounter type 6
  public EncounterType getRegReturnEncounterType() {
    return getEncounterType(EhrReportConstants.REGREVISIT_OUTPATIENT);
  }

  // encounter type 9
  public EncounterType getOpdEncounterType() {
    return getEncounterType(EhrReportConstants.OPDENCOUNTER_OUTPATIENT);
  }

  // encounter type 12
  public EncounterType getCheckInEncounterType() {
    return getEncounterType(EhrReportConstants.CHECKIN_ENCOUNTER);
  }

  // encounter type 19
  public EncounterType getAncEncounterType() {
    return getEncounterType(EhrReportConstants.ANC_ENCOUNTER);
  }

  // Concepts 5082
  public Concept getSpecialClinicConcept() {
    return getConcept(EhrReportConstants.SPECIAL_CLINIC);
  }

  // Concepts 5119
  public Concept getENTClinicConcept() {
    return getConcept(EhrReportConstants.ENT_CLINIC);
  }

  // Concepts 5118
  public Concept getEYEClinicConcept() {
    return getConcept(EhrReportConstants.EYE_CLINIC);
  }

  // Concepts 5698
  public Concept getTbLeprosyClinicConcept() {
    return getConcept(EhrReportConstants.TB_LEPROSY_CLINIC);
  }

  // Concepts 1073
  public Concept getSTIClinicConcept() {
    return getConcept(EhrReportConstants.STI_CLINIC);
  }

  // Concepts 5700
  public Concept getPsycthricClinicConcept() {
    return getConcept(EhrReportConstants.PSYCHIATRIC_CLINIC);
  }

  // Concepts 5121
  public Concept getOrthopedicClinicConcept() {
    return getConcept(EhrReportConstants.ORTHOPAEDIC_CLINIC);
  }

  // Concepts 5120
  public Concept getMopcMedicalClinicConcept() {
    return getConcept(EhrReportConstants.MOPC_MEDICAL_CLINIC);
  }

  // Concepts 5122
  public Concept getPopsPediatricClinicConcept() {
    return getConcept(EhrReportConstants.POPC_PAEDIATRICS_CLINIC);
  }

  // Concepts 5699
  public Concept getCccClinicConcept() {
    return getConcept(EhrReportConstants.CCC_CLINIC);
  }

  // Concepts 5701
  public Concept getMopsDmDiabeticClinicConcept() {
    return getConcept(EhrReportConstants.MOPC_DM_DIABETIC_CLINIC);
  }

  // Concepts 5702
  public Concept getFnaClinicConcept() {
    return getConcept(EhrReportConstants.FNA_CLINIC);
  }

  // Concepts 5703
  public Concept getGpcClinicConcept() {
    return getConcept(EhrReportConstants.GOPC_CLINIC);
  }

  // Concepts 5704
  public Concept getMchClinicConcept() {
    return getConcept(EhrReportConstants.MCH_CLINIC);
  }

  // Concepts 5705
  public Concept getMopsClinicConcept() {
    return getConcept(EhrReportConstants.MOPC_MEDICAL_CLINIC_2);
  }

  // Concepts 5706
  public Concept getPallativeClinicConcept() {
    return getConcept(EhrReportConstants.PALLIATIVE_CARE_CLINIC);
  }

  // Concepts 5707
  public Concept getSurgicalClinicConcept() {
    return getConcept(EhrReportConstants.SURGICAL_CLINIC);
  }

  // Concepts 5708
  public Concept getChestAndSkinClinicConcept() {
    return getConcept(EhrReportConstants.CHEST_AND_SKIN_CLINIC);
  }

  // Concepts 5696
  public Concept getDentalClinicConcept() {
    return getConcept(EhrReportConstants.DENTAL_CLINIC);
  }

  // Concepts 100126248
  public Concept getFamilyPlanningClinicConcept() {
    return getConcept(EhrReportConstants.FAMILY_PLANNING_CLINIC);
  }

  // 3999
  public Concept getTriageConcept() {
    return getConcept(EhrReportConstants.TRIAGE);
  }

  // 003
  public Concept getOpdWardConcept() {
    return getConcept(EhrReportConstants.OPD_WARD);
  }

  // 5114
  public Concept getCasualityOpdConcept() {
    return getConcept(EhrReportConstants.CASUALTY_OPD);
  }

  // 4000
  public Concept getCasualityTriageConcept() {
    return getConcept(EhrReportConstants.CASUALTY_TRIAGE);
  }

  // 5709
  public Concept getDentalOpdConcept() {
    return getConcept(EhrReportConstants.DENTAL_OPD);
  }

  // 2304
  public Concept getProvisionalDiagnosis() {
    return getConcept(EhrReportConstants.PROVISIONAL_DIAGNOSIS);
  }

  // 5109
  public Concept getFinalDiagnosis() {
    return getConcept(EhrReportConstants.FINAL_DIAGNOSIS);
  }

  // 3950
  public Concept getRegistrationFeeConcept() {
    return getConcept(EhrReportConstants.REGISTRATION_FEE);
  }

  // 009
  public Concept getNewPatientConcept() {
    return getConcept(EhrReportConstants.NEW_PATIENT);
  }

  // 945
  public Concept getRevisitConcept() {
    return getConcept(EhrReportConstants.REVISIT);
  }

  // Get all diarrhoea concepts
  public Concept getAcuteDiarrhoea() {
    return getConcept(EhrReportConstants.ACUTE_DIARRHEA);
  }

  // 4029
  public Concept getDiarrheaUnspecified() {
    return getConcept(EhrReportConstants.DIARRHEA_UNSPECIFIED);
  }

  // Get Dysentery Concepts
  // 2450
  public Concept getDysentery() {
    return getConcept(EhrReportConstants.DYSENTERY);
  }

  // 1003
  public Concept getAmoebicDysentery() {
    return getConcept(EhrReportConstants.AMOEBIC_DYSENTERY);
  }

  // 1668
  public Concept getShigellaDysentery() {
    return getConcept(EhrReportConstants.SHIGELLA_DYSENTERY);
  }

  // 3667
  public Concept getBacillaryDysentery() {
    return getConcept(EhrReportConstants.BACILLARY_DYSENTERY);
  }

  // Meningococal concepts
  // 100001518
  public Concept getMeningococcalMenengaitis() {
    return getConcept(EhrReportConstants.MENINGOCOCCAL_MENINGITIS);
  }

  // 1714
  public Concept getMeningococcalInfections() {
    return getConcept(EhrReportConstants.MENINGOCOCCAL_INFECTIONS);
  }

  // 1019
  public Concept getMeningococcalNos() {
    return getConcept(EhrReportConstants.MENINGITIS_NOS);
  }

  // Other meningitis concepts

  public Concept getBacterialMeningitisConcept() {
    return getConcept(EhrReportConstants.BACTERIAL_MENINGITIS);
  }

  public Concept getCryptococcalMeningitisConcept() {
    return getConcept(EhrReportConstants.CRYPTOCOCCAL_MENINGITIS);
  }

  public Concept getViralMeningitisConcept() {
    return getConcept(EhrReportConstants.VIRAL_MENINGITIS);
  }

  // Tetanus concepts
  // 1521
  public Concept getTetanus() {
    return getConcept(EhrReportConstants.TETANUS);
  }

  // 1519
  public Concept getTetanusNeonatorumTetanus() {
    return getConcept(EhrReportConstants.TETANUS_NEONATORUM);
  }

  // 1195
  public Concept getAcutePoliomyelitisConcept() {
    return getConcept(EhrReportConstants.ACUTE_POLIOMYELITIS);
  }

  // 1146
  public Concept getChickenPoxConcept() {
    return getConcept(EhrReportConstants.CHICKEN_POX);
  }

  // 1020
  public Concept getMeaslesConcept() {
    return getConcept(EhrReportConstants.MEASLES);
  }

  // 4458
  public Concept getMeaslesWithoutComplicationConcept() {
    return getConcept(EhrReportConstants.MEASLES_WITHOUT_COMPLICATION);
  }

  // 1744
  public Concept getGermanMeaslesConcept() {
    return getConcept(EhrReportConstants.GERMAN_MEASLES);
  }

  public Concept getHepatitisNosConcept() {
    return getConcept(EhrReportConstants.HEPATITIS_NOS);
  }

  public Concept getHepatitisAConcept() {
    return getConcept(EhrReportConstants.HEPATITIS_A);
  }

  // 1006
  public Concept getHepatitisBConcept() {
    return getConcept(EhrReportConstants.HEPATITIS_B);
  }

  // 1007
  public Concept getHepatitisCConcept() {
    return getConcept(EhrReportConstants.HEPATITIS_C);
  }

  public Concept getHepatitisEConcept() {
    return getConcept(EhrReportConstants.HEPATITIS_E);
  }

  public Concept getViralHepatitisAConcept() {
    return getConcept(EhrReportConstants.VIRAL_HEPATITIS_A);
  }

  public Concept getViralHepatitisBConcept() {
    return getConcept(EhrReportConstants.VIRAL_HEPATITIS_B);
  }

  public Concept getViralHepatitisEConcept() {
    return getConcept(EhrReportConstants.VIRAL_HEPATITIS_D);
  }

  public Concept getViralHepatitisDConcept() {
    return getConcept(EhrReportConstants.VIRAL_HEPATITIS_E);
  }

  public Concept getLiverInfectionWithHepatitisAConcept() {
    return getConcept(EhrReportConstants.LIVER_INFECTION_WITH_HEPATITIS_A);
  }

  public Concept getMumpsConcept() {
    return getConcept(EhrReportConstants.MUMPS);
  }

  public Concept getRespiratoryDistressHaemorrhagicFeversConcept() {
    return getConcept(EhrReportConstants.RESPIRATORY_DISTRESS_HAEMORRHAGIC_FEVERS);
  }

  public Concept getFeverConcept() {
    return getConcept(EhrReportConstants.FEVER);
  }

  public Concept getFeverOfUnknownOriginConcept() {
    return getConcept(EhrReportConstants.FEVER_OF_UNKNOWN_ORIGIN);
  }

  public Concept getClinicalMalariaConcept() {
    return getConcept(EhrReportConstants.CLINICAL_MALARIA);
  }

  public Concept getMalariaInPregnancyConcept() {
    return getConcept(EhrReportConstants.MALARIA_IN_PREGNANCY);
  }

  public Concept getMalariaDueToSimianPlasmodiaConcept() {
    return getConcept(EhrReportConstants.MALARIA_DUE_TO_SIMIAN_PLASMODIA);
  }

  public Concept getOtherCongenitalMalariaConcept() {
    return getConcept(EhrReportConstants.OTHER_CONGENITAL_MALARIA);
  }

  public Concept getOtherSpecifiedMalariaConcept() {
    return getConcept(EhrReportConstants.OTHER_SPECIFIED_MALARIA);
  }

  public Concept getPlasmodiumMalariaeMalariaConcept() {
    return getConcept(EhrReportConstants.PLASMODIUM_MALARIAE_MALARIA);
  }

  public Concept getUnspecifiedMalariaConcept() {
    return getConcept(EhrReportConstants.UNSPECIFIED_MALARIA);
  }

  public Concept getUrinaryTractInfecionConcept() {
    return getConcept(EhrReportConstants.URINARY_TRACT_INFECTION);
  }

  public Concept getUrinaryTractInfecionInPregnancyConcept() {
    return getConcept(EhrReportConstants.URINARY_TRACT_INFECTION_IN_PREGNANCY);
  }

  public Concept getUrinaryTractInfecionInPregnancyNotSpecifiedConcept() {
    return getConcept(EhrReportConstants.URINARY_TRACT_INFECTION_IN_PREGNANCY_NOT_SPECIFIED);
  }

  public Concept getInfectionOfOtherStomaOfUrinayTractConcept() {
    return getConcept(EhrReportConstants.INFECTION_OF_OTHER_STOMA_OF_URINARY_TRACT);
  }

  public Concept getInfectionOfOtherPartsOfUrinayTractConceptInPregnancyConcept() {
    return getConcept(EhrReportConstants.INFECTIONS_OF_OTHER_PARTS_OF_URINARY_TRACT_IN_PREGNANCY);
  }

  public Concept getTyphoidFeverConcept() {
    return getConcept(EhrReportConstants.TYPHOID_FEVER);
  }

  public Concept getBilhaziaConcept() {
    return getConcept(EhrReportConstants.BILHARZIA);
  }

  public Concept getOtherSchitosomiasisConcept() {
    return getConcept(EhrReportConstants.OTHER_SCHISTOSOMIASIS);
  }

  public Concept getIntestnalWormsConcept() {
    return getConcept(EhrReportConstants.INTESTINAL_WORMS);
  }

  public Concept getMalnutritionConcept() {
    return getConcept(EhrReportConstants.MALNUTRITION);
  }

  public Concept getProteinEnergyMalnutritionConcept() {
    return getConcept(EhrReportConstants.PROTEIN_ENERGY_MALNUTRITION);
  }

  public Concept getAnaemiaUnspecifiedConcept() {
    return getConcept(EhrReportConstants.ANAEMIA_UNSPECIFIED);
  }

  public Concept getHaemolyticAnaemiaConcept() {
    return getConcept(EhrReportConstants.HAEMOLYTIC_ANAEMIA);
  }

  public Concept getBloodLossAnaemiaConcept() {
    return getConcept(EhrReportConstants.BLOOD_LOSS_ANAEMIA);
  }

  public Concept getSickleCellAnaemiaConcept() {
    return getConcept(EhrReportConstants.SICKLE_CELL_ANAEMIA);
  }

  public Concept getAsthenopiaConcept() {
    return getConcept(EhrReportConstants.ASTHENOPIA);
  }

  public Concept getPinkEyeConcept() {
    return getConcept(EhrReportConstants.PINK_EYE);
  }

  public Concept getDryEyeSyndromeConcept() {
    return getConcept(EhrReportConstants.DRY_EYE_SYNDROME);
  }

  public Concept getInjuryOfEyeConcept() {
    return getConcept(EhrReportConstants.INJURY_OF_EYE);
  }

  public Concept getLowVisionBothEyeConcept() {
    return getConcept(EhrReportConstants.LOW_VISION_BOTH_EYES);
  }

  public Concept getOpenWoundEyelidAndPerocularAreaConcept() {
    return getConcept(EhrReportConstants.OPEN_WOUND_OF_EYELID_AND_PERIOCULAR_AREA);
  }

  public Concept getHydrocortisoneConcept() {
    return getConcept(EhrReportConstants.HYDROCORTISONE);
  }

  public Concept getRetrobulbarNeuritisLeftEyeConcept() {
    return getConcept(EhrReportConstants.RETROBULBAR_NEURITIS_LEFT_EYE);
  }

  public Concept getAcuteAtopicConjuctivitisRightEyeConcept() {
    return getConcept(EhrReportConstants.ACUTE_ATOPIC_CONJUCTIVITIS_RIGHT_EYE);
  }

  public Concept getEarInfectionsConcept() {
    return getConcept(EhrReportConstants.EAR_INFECTIONS);
  }

  public Concept getDischargeOfEarConcept() {
    return getConcept(EhrReportConstants.DISCHARGE_OF_EAR);
  }
  // TO Do pending more ear inections
  public Concept getUpperRespiratoryTractInfectionConcept() {
    return getConcept(EhrReportConstants.UPPER_RESPIRATORY_TRACT_INFECTION);
  }

  public Concept getUpperRespiratoryTractInfectionHyperSensitivityReactionSiteUnspecifiedConcept() {
    return getConcept(
        EhrReportConstants.UPPER_RESPIRATORY_TRACT_HYPERSENSITIVITY_REACTION_SITE_UNSPECIFIED);
  }

  public Concept getDiseasesOfUpperRespiratoryTractUnspecifiedConcept() {
    return getConcept(EhrReportConstants.DISEASES_OF_UPPER_RESPIRATORY_TRACT_UNSPECIFIED);
  }

  public Concept getOtherDiseasesOfUpperRespiratoryTractConcept() {
    return getConcept(EhrReportConstants.OTHER_DISEASES_OF_UPPER_RESPIRATORY_TRACT);
  }

  public Concept getOtherSpecifiedDiseasesOfUpperRespiratoryTractConcept() {
    return getConcept(EhrReportConstants.OTHER_SPECIFIED_DISEASES_OF_UPPER_RESPIRATORY_TRACT);
  }

  public Concept getAsthmaNosConcept() {
    return getConcept(EhrReportConstants.ASTHMA_NOS);
  }

  public Concept getAstheNopiaConcept() {
    return getConcept(EhrReportConstants.ASTHENOPIA);
  }

  public Concept getAsthmaUnspecifiedConcept() {
    return getConcept(EhrReportConstants.ASTHMA_UNSPECIFIED);
  }

  // 1712
  public Concept getObstericalTetanus() {
    return getConcept(EhrReportConstants.OBSTETRICAL_TETANUS);
  }

  public Concept getTuberculosisConcept() {
    return getConcept(EhrReportConstants.TUBERCULOSIS);
  }

  // TUBERCULOSIS_OF_OTHER_ORGANS
  public Concept getTBOtherOrgansConcept() {
    return getConcept(EhrReportConstants.TUBERCULOSIS_OF_OTHER_ORGANS);
  }

  // TUBERCULOSIS_IN_PREGNANCY
  public Concept getTBInPregnancyConcept() {
    return getConcept(EhrReportConstants.TUBERCULOSIS_IN_PREGNANCY);
  }

  // TUBERCULOSIS_AFFECTING_CENTRAL_NERVOUS_SYSTEM
  public Concept getTBAffectingCentralNervousSystemConcept() {
    return getConcept(EhrReportConstants.TUBERCULOSIS_AFFECTING_CENTRAL_NERVOUS_SYSTEM);
  }

  // TUBERCULOSIS_OF_THE_GENITOURINARY_SYSTEM
  public Concept getTBOfTheGenitourinarySystemConcept() {
    return getConcept(EhrReportConstants.TUBERCULOSIS_OF_THE_GENITOURINARY_SYSTEM);
  }

  // MILIARY_TUBERCULOSIS
  public Concept getMiliaryTBConcept() {
    return getConcept(EhrReportConstants.MILIARY_TUBERCULOSIS);
  }

  // PULMONARY_TUBERCULOSIS
  public Concept getPulmonaryTBConcept() {
    return getConcept(EhrReportConstants.PULMONARY_TUBERCULOSIS);
  }

  // SEQUELAE_OF_TUBERCULOSIS
  public Concept getSequelaeOfTBConcept() {
    return getConcept(EhrReportConstants.SEQUELAE_OF_TUBERCULOSIS);
  }

  // RESPIRATORY_TUBERCULOSIS
  public Concept getRespiratoryTBConcept() {
    return getConcept(EhrReportConstants.RESPIRATORY_TUBERCULOSIS);
  }

  // RESPIRATORY_TUBERCULOSIS_UNSPECIFIED
  public Concept getRespiratoryTBUnsuspectedConcept() {
    return getConcept(EhrReportConstants.RESPIRATORY_TUBERCULOSIS_UNSPECIFIED);
  }

  // TUBERCULOSIS_HISTOLOGICALLY_CONFIRMED
  public Concept getTBHistologicallyConfirmedConcept() {
    return getConcept(EhrReportConstants.TUBERCULOSIS_HISTOLOGICALLY_CONFIRMED);
  }

  // RESPIRATORY_TUBERCULOSIS_NOT_CONFIRMED_BACTERIOLOGICALLY_AND_HISTOLOGICALLY
  public Concept getRespiratoryTBNotConfirmedBacteriologicallyAndHistologicallyConcept() {
    return getConcept(
        EhrReportConstants
            .RESPIRATORY_TUBERCULOSIS_NOT_CONFIRMED_BACTERIOLOGICALLY_AND_HISTOLOGICALLY);
  }

  // EXTRAPULMONARY_TUBERCULOSIS
  public Concept getExtrapulmonaryTBConcept() {
    return getConcept(EhrReportConstants.EXTRAPULMONARY_TUBERCULOSIS);
  }

  // ACUTE_MILIARY_TUBERCULOSIS_UNSPECIFIED
  public Concept getAcuteMiliaryTBUspecifiedConcept() {
    return getConcept(EhrReportConstants.ACUTE_MILIARY_TUBERCULOSIS_UNSPECIFIED);
  }

  // OTHER_RESPIRATORY_TUBERCULOSIS
  public Concept getOtherRespiratoryTBConcept() {
    return getConcept(EhrReportConstants.OTHER_RESPIRATORY_TUBERCULOSIS);
  }

  // MULTI_DRUG_RESISTANT_TUBERCULOSIS
  public Concept getMultiDrugResistantTBConcept() {
    return getConcept(EhrReportConstants.MULTI_DRUG_RESISTANT_TUBERCULOSIS);
  }

  // SPUTUM_POSITIVE_PULMONARY_TUBERCULOSIS
  public Concept getSputumPositivePulmonaryTB() {
    return getConcept(EhrReportConstants.SPUTUM_POSITIVE_PULMONARY_TUBERCULOSIS);
  }

  // SPUTUM_NEGATIVE_PULMONARY_TUBERCULOSIS
  public Concept getSputumNegativeTBConcept() {
    return getConcept(EhrReportConstants.SPUTUM_NEGATIVE_PULMONARY_TUBERCULOSIS);
  }

  // CONTACT_WITH_AND_SUSPECTED_EXPOSURE_TO_TUBERCULOSIS
  public Concept getContactWithAndExposureToTB() {
    return getConcept(EhrReportConstants.CONTACT_WITH_AND_SUSPECTED_EXPOSURE_TO_TUBERCULOSIS);
  }

  // ENCOUNTER_FOR_SCREENING_FOR_RESPIRATORY_TUBERCULOSIS
  public Concept getEncounterForScreeningForRespiratoryTB() {
    return getConcept(EhrReportConstants.ENCOUNTER_FOR_SCREENING_FOR_RESPIRATORY_TUBERCULOSIS);
  }

  public Concept getTonsillitisConcept() {
    return getConcept(EhrReportConstants.TONSILLITIS);
  }

  public Concept getCholeraConcept() {
    return getConcept(EhrReportConstants.CHOLERA);
  }

  public Concept getPneumoniaConcept() {
    return getConcept(EhrReportConstants.PNEUMONIA);
  }

  public Concept getOtherDiseaseOfRespiratorySystemConcept() {
    return getConcept(EhrReportConstants.OTHER_DISEASE_OF_RESPIRATORY_SYSTEM);
  }

  public Concept getMentalDisorderSConcept() {
    return getConcept(EhrReportConstants.MENTAL_DISORDERS);
  }

  public Concept getDentalDisorderSConcept() {
    return getConcept(EhrReportConstants.DENTAL_DISORDERS);
  }

  public Concept getJiggersInfestationConcept() {
    return getConcept(EhrReportConstants.JIGGERS_INFESTATION);
  }

  public Concept getDiseaseOfTheSkinConcept() {
    return getConcept(EhrReportConstants.DISEASE_OF_THE_SKIN);
  }

  public Concept getChromosomalAbnormalitiesConcept() {
    return getConcept(EhrReportConstants.CHROMOSOMAL_ABNORMALITIES);
  }

  public Concept getCongenitalAnomaliesConcept() {
    return getConcept(EhrReportConstants.CONGENITAL_ANOMALIES);
  }

  public Concept getPoisoningConcept() {
    return getConcept(EhrReportConstants.POISONING);
  }

  public Concept getRoadTrafficInjuriesConcept() {
    return getConcept(EhrReportConstants.ROAD_TRAFFIC_INJURIES);
  }

  public Concept getOtherInjuriesConcept() {
    return getConcept(EhrReportConstants.OTHER_INJURIES);
  }

  public Concept getSexualAssaultConcept() {
    return getConcept(EhrReportConstants.SEXUAL_ASSAULT);
  }

  public Concept getBurnsConcept() {
    return getConcept(EhrReportConstants.BURNS);
  }

  public Concept getSnakeBitesConcept() {
    return getConcept(EhrReportConstants.SNAKE_BITES);
  }

  public Concept getDogBitesConcept() {
    return getConcept(EhrReportConstants.DOG_BITES);
  }

  public Concept getOtherBitesConcept() {
    return getConcept(EhrReportConstants.OTHER_BITES);
  }

  public Concept getOtherDiabetesConcept() {
    return getConcept(EhrReportConstants.DIABETES);
  }

  public Concept getEpilepsyConcept() {
    return getConcept(EhrReportConstants.EPILEPSY);
  }

  public Concept getOtherConvulsiveDisordersConcept() {
    return getConcept(EhrReportConstants.OTHER_CONVULSIVE_DISORDERS);
  }

  public Concept getNewlyDiagnosedHivConcept() {
    return getConcept(EhrReportConstants.NEWLY_DIAGNOSED_HIV);
  }

  public Concept getBrucellosisConcept() {
    return getConcept(EhrReportConstants.BRUCELLOSIS);
  }

  public Concept getRicketsConcept() {
    return getConcept(EhrReportConstants.RICKETS);
  }

  public Concept getCardiovascularConditionConcept() {
    return getConcept(EhrReportConstants.CARDIVASCULAR_CONDITIONS);
  }

  public Concept getViolenceRelatedInjuriesConcept() {
    return getConcept(EhrReportConstants.VIOLENCE_RELATED_INJURIES);
  }

  public Concept getCerebralPalsyConcept() {
    return getConcept(EhrReportConstants.CEREBRAL_PALSY);
  }

  public Concept getAutismConcept() {
    return getConcept(EhrReportConstants.AUTISM);
  }

  public Concept getOtherCentralNarvousSytemConditionConcept() {
    return getConcept(EhrReportConstants.OTHER_CENTRAL_NERVOUS_SYSTEM_CONDITIONS);
  }

  public Concept getTryponosomiasisConcept() {
    return getConcept(EhrReportConstants.TRYPONOSOMIASIS);
  }

  public Concept getKalazarConcept() {
    return getConcept(EhrReportConstants.KALAZAR);
  }

  public Concept getDracunculosisConcept() {
    return getConcept(EhrReportConstants.DRACUNCULOSIS);
  }

  public Concept getYellowFeverConcept() {
    return getConcept(EhrReportConstants.YELLOW_FEVER);
  }

  public Concept getViralHaemorrhagicFeverConcept() {
    return getConcept(EhrReportConstants.VIRAL_HAEMORRHAGIC_FEVER);
  }

  public Concept getPlagueConcept() {
    return getConcept(EhrReportConstants.PLAGUE);
  }

  public Concept getDeathtsDueToRoadTrafficInjuriesConcept() {
    return getConcept(EhrReportConstants.DEATHS_DUE_TO_ROAD_TRAFFIC_INJURIES);
  }

  public Concept getSexuallyTransmittedInfectionsConcept() {
    return getConcept(EhrReportConstants.SEXUALLY_TRANSMITTED_INFECTIONS);
  }

  public Concept getGonorrhoeaConcept() {
    return getConcept(EhrReportConstants.GONORROHEA);
  }

  public Concept getHpvConcept() {
    return getConcept(EhrReportConstants.HPV);
  }

  public Concept getGenitalHerpesConcept() {
    return getConcept(EhrReportConstants.GENITAL_HERPES);
  }

  public Concept getChlamydiaConcept() {
    return getConcept(EhrReportConstants.CHLAMYDIA);
  }

  public Concept getHivConcept() {
    return getConcept(EhrReportConstants.HIV);
  }

  public Concept getTrichomoniasisInfectionConcept() {
    return getConcept(EhrReportConstants.TRICHOMONIASIS_INFECTION);
  }

  public Concept getHerpesSimplexConcept() {
    return getConcept(EhrReportConstants.HERPES_SIMPLEX);
  }

  public Concept getHerpesZosterConcept() {
    return getConcept(EhrReportConstants.HERPES_ZOSTER);
  }

  public Concept getHerpesZosterOphthalmicusConcept() {
    return getConcept(EhrReportConstants.HERPES_ZOSTER_OPHTHALMICUS);
  }

  public Concept getHerpesviralInfectionUnspecifiedConcept() {
    return getConcept(EhrReportConstants.HERPESVIRAL_INFECTION_UNSPECIFIED);
  }

  public Concept getAnogenitalHerpesSimplexVirusInfectionConcept() {
    return getConcept(EhrReportConstants.ANOGENITAL_HERPES_SIMPLEX_VIRUS_INFECTION);
  }

  public Concept getChacroidConcept() {
    return getConcept(EhrReportConstants.CHANCROID);
  }

  public Concept getCompleteAbortionConcept() {
    return getConcept(EhrReportConstants.COMPLETE_ABORTION);
  }

  public Concept getIncompleteAbortionConcept() {
    return getConcept(EhrReportConstants.INCOMPLETE_ABORTION);
  }

  public Concept getIncompleteSpontaneousAbortionConcept() {
    return getConcept(EhrReportConstants.INCOMPLETE_SPONTANEOUS_ABORTION_WITHOUT_COMPLICATION);
  }

  public Concept getInevitableAbortionConcept() {
    return getConcept(EhrReportConstants.INEVITABLE_ABORTION);
  }

  public Concept getMedicalAbortionConcept() {
    return getConcept(EhrReportConstants.MEDICAL_ABORTION);
  }

  public Concept getMissedAbortionConcept() {
    return getConcept(EhrReportConstants.MISSED_ABORTION);
  }

  public Concept getRecurentAbortionConcept() {
    return getConcept(EhrReportConstants.RECURRENT_ABORTION);
  }

  public Concept getSepticAbortionConcept() {
    return getConcept(EhrReportConstants.SEPTIC_ABORTION);
  }

  public Concept getThreatenedAbortionConcept() {
    return getConcept(EhrReportConstants.THREATENED_ABORTION);
  }

  public Concept getUnspecifiedSpontaneousAbortionWithOtherComplicationsConcept() {
    return getConcept(EhrReportConstants.UNSPECIFIED_SPONTANEOUS_ABORTION_WITH_OTHER_COMPLICATIONS);
  }

  public Concept getHypertensionConcept() {
    return getConcept(EhrReportConstants.HYPERTENSION);
  }

  public Concept getPrimaryHypertensionConcept() {
    return getConcept(EhrReportConstants.PRIMARY_HYPERTENSION);
  }

  public Concept getDiseaseOfPuerperiumAndChildBirthConcept() {
    return getConcept(EhrReportConstants.DISEASE_OF_PUERPERUM_AND_CHILD_BIRTH);
  }

  /**
   * Get patient referred from concept
   *
   * @return Concept
   */
  public Concept getPatientReferredFrom() {
    return getConcept(EhrReportConstants.PATIENT_REFERRED_FROM);
  }

  /**
   * Get patient referred externally concept
   *
   * @return Concept
   */
  public Concept getPatientReferredExternally() {
    return getConcept(EhrReportConstants.EXTERNAL_REFERRAL);
  }

  /**
   * programs ANC program
   *
   * @return Program
   */
  public Program getAncProgram() {
    return getProgram(EhrReportConstants.ANC_Program);
  }

  /**
   * programs PNC program
   *
   * @return Program
   */
  public Program getPncProgram() {
    return getProgram(EhrReportConstants.PNC_Program);
  }

  /**
   * programs CWC program
   *
   * @return Program
   */
  public Program getCwcProgram() {
    return getProgram(EhrReportConstants.CWC_Program);
  }

  /**
   * Diagnosis class ID 4
   *
   * @return ConceptClass
   */
  public ConceptClass getDiagnosisConceptClass() {
    return Context.getConceptService().getConceptClassByUuid(EhrReportConstants.DIAGNOSIS_CLASS);
  }

  /**
   * Finding class ID 5
   *
   * @return ConceptClass
   */
  public ConceptClass getFindingConceptClass() {
    return Context.getConceptService().getConceptClassByUuid(EhrReportConstants.FINDING_CLASS);
  }

  /**
   * Finding class ID 12
   *
   * @return ConceptClass
   */
  public ConceptClass getSymptomsConceptClass() {
    return Context.getConceptService().getConceptClassByUuid(EhrReportConstants.SYMPTOMS_CLASS);
  }

  /**
   * Finding/Symptoms class ID 13
   *
   * @return ConceptClass
   */
  public ConceptClass getSymptomsFindingsConceptClass() {
    return Context.getConceptService()
        .getConceptClassByUuid(EhrReportConstants.SYMPTOMS_FINDING_CLASS);
  }
}

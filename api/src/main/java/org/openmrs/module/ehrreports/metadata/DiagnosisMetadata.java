package org.openmrs.module.ehrreports.metadata;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiagnosisMetadata extends Metadata {
  @Autowired private OutpatientMetadata outpatientMetadata;

  /**
   * Get all diarrohea concepts as a list
   *
   * @return List<Interger></Interger>
   */
  public List<Integer> getDiarrhoeaConceptList() {
    return Arrays.asList(
        outpatientMetadata.getAcuteDiarrhoea().getConceptId(),
        outpatientMetadata.getDiarrheaUnspecified().getConceptId());
  }

  public List<Integer> getTuberculosisConceptList() {
    return Arrays.asList(
        outpatientMetadata.getTuberculosisConcept().getConceptId(),
        outpatientMetadata.getTBOtherOrgansConcept().getConceptId(),
        outpatientMetadata.getTBInPregnancyConcept().getConceptId(),
        outpatientMetadata.getTBAffectingCentralNervousSystemConcept().getConceptId(),
        outpatientMetadata.getTBOfTheGenitourinarySystemConcept().getConceptId(),
        outpatientMetadata.getMiliaryTBConcept().getConceptId(),
        outpatientMetadata.getPulmonaryTBConcept().getConceptId(),
        outpatientMetadata.getSequelaeOfTBConcept().getConceptId(),
        outpatientMetadata.getRespiratoryTBConcept().getConceptId(),
        outpatientMetadata.getRespiratoryTBUnsuspectedConcept().getConceptId(),
        outpatientMetadata.getTBHistologicallyConfirmedConcept().getConceptId(),
        outpatientMetadata
            .getRespiratoryTBNotConfirmedBacteriologicallyAndHistologicallyConcept()
            .getConceptId(),
        outpatientMetadata.getExtrapulmonaryTBConcept().getConceptId(),
        outpatientMetadata.getAcuteMiliaryTBUspecifiedConcept().getConceptId(),
        outpatientMetadata.getOtherRespiratoryTBConcept().getConceptId(),
        outpatientMetadata.getMultiDrugResistantTBConcept().getConceptId(),
        outpatientMetadata.getSputumPositivePulmonaryTB().getConceptId(),
        outpatientMetadata.getSputumNegativeTBConcept().getConceptId(),
        outpatientMetadata.getContactWithAndExposureToTB().getConceptId(),
        outpatientMetadata.getEncounterForScreeningForRespiratoryTB().getConceptId());
  }

  public List<Integer> getDysenteryList() {
    return Arrays.asList(
        outpatientMetadata.getDysentery().getConceptId(),
        outpatientMetadata.getAmoebicDysentery().getConceptId(),
        outpatientMetadata.getBacillaryDysentery().getConceptId(),
        outpatientMetadata.getShigellaDysentery().getConceptId());
  }

  public List<Integer> getMenongococcalInfectionsList() {
    return Arrays.asList(
        outpatientMetadata.getMeningococcalInfections().getConceptId(),
        outpatientMetadata.getMeningococcalMenengaitis().getConceptId());
  }

  public List<Integer> getCholeraList() {
    return Arrays.asList(outpatientMetadata.getCholeraConcept().getConceptId());
  }

  public List<Integer> getTonsillitisConceptList() {
    return Arrays.asList(outpatientMetadata.getTonsillitisConcept().getConceptId());
  }

  public List<Integer> getPneumoniaConceptList() {
    return Arrays.asList(outpatientMetadata.getPneumoniaConcept().getConceptId());
  }

  public List<Integer> getOtherDiseaseOfRespiratorySystemConceptList() {
    return Arrays.asList(
        outpatientMetadata.getOtherDiseaseOfRespiratorySystemConcept().getConceptId());
  }

  public List<Integer> getMentalDisordersConceptList() {
    return Arrays.asList(outpatientMetadata.getMentalDisorderSConcept().getConceptId());
  }

  public List<Integer> getDentalDisordersConceptList() {
    return Arrays.asList(outpatientMetadata.getDentalDisorderSConcept().getConceptId());
  }

  public List<Integer> getJiggersInfestationConceptList() {
    return Arrays.asList(outpatientMetadata.getJiggersInfestationConcept().getConceptId());
  }

  public List<Integer> getDiseaseOfTheSkinConceptList() {
    return Arrays.asList(outpatientMetadata.getDiseaseOfTheSkinConcept().getConceptId());
  }

  public List<Integer> getChromosomalAbnormalitiesConceptList() {
    return Arrays.asList(outpatientMetadata.getChromosomalAbnormalitiesConcept().getConceptId());
  }

  public List<Integer> getCongenitalAnomaliesConceptList() {
    return Arrays.asList(outpatientMetadata.getCongenitalAnomaliesConcept().getConceptId());
  }

  public List<Integer> getPoisoningConceptList() {
    return Arrays.asList(outpatientMetadata.getPoisoningConcept().getConceptId());
  }

  public List<Integer> getRoadTrafficInjuriesConceptList() {
    return Arrays.asList(outpatientMetadata.getRoadTrafficInjuriesConcept().getConceptId());
  }

  public List<Integer> getRoadOtherInjuriesConceptList() {
    return Arrays.asList(outpatientMetadata.getOtherInjuriesConcept().getConceptId());
  }

  public List<Integer> getSexualAssaultConceptList() {
    return Arrays.asList(outpatientMetadata.getSexualAssaultConcept().getConceptId());
  }

  public List<Integer> getBurnsConceptList() {
    return Arrays.asList(outpatientMetadata.getBurnsConcept().getConceptId());
  }

  public List<Integer> getSnakeBitesConceptList() {
    return Arrays.asList(outpatientMetadata.getSnakeBitesConcept().getConceptId());
  }

  public List<Integer> getDogBitesConceptList() {
    return Arrays.asList(outpatientMetadata.getDogBitesConcept().getConceptId());
  }

  public List<Integer> getOtherBitesConceptList() {
    return Arrays.asList(outpatientMetadata.getOtherBitesConcept().getConceptId());
  }

  public List<Integer> getDiabetesConceptList() {
    return Arrays.asList(outpatientMetadata.getOtherDiabetesConcept().getConceptId());
  }

  public List<Integer> getEpilepsyConceptList() {
    return Arrays.asList(outpatientMetadata.getEpilepsyConcept().getConceptId());
  }

  public List<Integer> getOtherConvulsiveDisordersConceptList() {
    return Arrays.asList(outpatientMetadata.getOtherConvulsiveDisordersConcept().getConceptId());
  }

  public List<Integer> getNewlyDiagnoseHivConceptList() {
    return Arrays.asList(outpatientMetadata.getNewlyDiagnosedHivConcept().getConceptId());
  }

  public List<Integer> getBrucellosisConceptList() {
    return Arrays.asList(outpatientMetadata.getBrucellosisConcept().getConceptId());
  }

  public List<Integer> getRicketsConceptList() {
    return Arrays.asList(outpatientMetadata.getRicketsConcept().getConceptId());
  }

  public List<Integer> getCardiovascularConditionConceptList() {
    return Arrays.asList(outpatientMetadata.getCardiovascularConditionConcept().getConceptId());
  }

  public List<Integer> getViolenceRelatedInjuriesConceptList() {
    return Arrays.asList(outpatientMetadata.getViolenceRelatedInjuriesConcept().getConceptId());
  }

  public List<Integer> getCerebralPalsyConceptList() {
    return Arrays.asList(outpatientMetadata.getCerebralPalsyConcept().getConceptId());
  }

  public List<Integer> getAutismConceptList() {
    return Arrays.asList(outpatientMetadata.getAutismConcept().getConceptId());
  }

  public List<Integer> getOtherCentralNarvousSytemConditionConceptList() {
    return Arrays.asList(
        outpatientMetadata.getOtherCentralNarvousSytemConditionConcept().getConceptId());
  }

  public List<Integer> getTryponosomiasisConceptList() {
    return Arrays.asList(outpatientMetadata.getTryponosomiasisConcept().getConceptId());
  }

  public List<Integer> getKalazarConceptList() {
    return Arrays.asList(outpatientMetadata.getKalazarConcept().getConceptId());
  }

  public List<Integer> getDracunculosisConceptList() {
    return Arrays.asList(outpatientMetadata.getDracunculosisConcept().getConceptId());
  }

  public List<Integer> getYellowFeverConceptList() {
    return Arrays.asList(outpatientMetadata.getYellowFeverConcept().getConceptId());
  }

  public List<Integer> getViralHaemorrhagicFeverConceptList() {
    return Arrays.asList(outpatientMetadata.getViralHaemorrhagicFeverConcept().getConceptId());
  }

  public List<Integer> getPlagueConceptList() {
    return Arrays.asList(outpatientMetadata.getPlagueConcept().getConceptId());
  }

  public List<Integer> getDeathtsDueToRoadTrafficInjuriesConceptList() {
    return Arrays.asList(
        outpatientMetadata.getDeathtsDueToRoadTrafficInjuriesConcept().getConceptId());
  }
}

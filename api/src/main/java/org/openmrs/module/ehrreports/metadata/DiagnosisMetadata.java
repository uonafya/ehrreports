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
}

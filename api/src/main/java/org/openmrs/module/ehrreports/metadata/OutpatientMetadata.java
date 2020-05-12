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
import org.openmrs.EncounterType;
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
}

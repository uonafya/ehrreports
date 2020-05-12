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

  // Concepts
  public Concept getSpecialClinicConcept() {
    return getConcept(EhrReportConstants.SPECIAL_CLINIC);
  }
}

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
import org.openmrs.api.context.Context;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.calculation.PatientOccurenceCalculation;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CalculationCohortDefinition;
import org.openmrs.module.ehrreports.reporting.library.queries.moh717.Moh717Queries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh717CohortQueries {

  @Autowired private OutpatientMetadata outpatientMetadata;

  public CohortDefinition getOutPatients() {

    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Outpatient");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh717Queries.getOutPatientClinicPatients(
            outpatientMetadata.getAdultsInitialEncounterType().getEncounterTypeId(),
            outpatientMetadata.getAdultReturnEncounterType().getEncounterTypeId(),
            outpatientMetadata.getPedsInitialEncounterType().getEncounterTypeId(),
            outpatientMetadata.getPedsReturnEncounterType().getEncounterTypeId(),
            outpatientMetadata.getRegInitialEncounterType().getEncounterTypeId(),
            outpatientMetadata.getRegReturnEncounterType().getEncounterTypeId(),
            outpatientMetadata.getOpdEncounterType().getEncounterTypeId()));
    return cd;
  }

  /**
   * Get special clinic patients
   *
   * @param
   * @return
   */
  public CohortDefinition getSpecialClinicPatients(int answer) {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Special Clinic Patients");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh717Queries.getSpecialClinicPatients(
            outpatientMetadata.getAdultsInitialEncounterType().getEncounterTypeId(),
            outpatientMetadata.getAdultReturnEncounterType().getEncounterTypeId(),
            outpatientMetadata.getPedsInitialEncounterType().getEncounterTypeId(),
            outpatientMetadata.getPedsReturnEncounterType().getEncounterTypeId(),
            outpatientMetadata.getCheckInEncounterType().getEncounterTypeId(),
            outpatientMetadata.getAncEncounterType().getEncounterTypeId(),
            outpatientMetadata.getSpecialClinicConcept().getConceptId(),
            answer));
    return cd;
  }

  public CohortDefinition getPatientStates(EhrReportConstants.OccurenceStates state) {
    CalculationCohortDefinition cd =
        new CalculationCohortDefinition(
            "On ART for at least 3 months",
            Context.getRegisteredComponents(PatientOccurenceCalculation.class).get(0));
    cd.addParameter(new Parameter("onOrBefore", "End Date", Date.class));
    cd.addCalculationParameter("state", state);
    return cd;
  }
 public CohortDefinition getMchClients(int answer) {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Mch Clients");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
            Moh717Queries.getMchClients(
                    outpatientMetadata.getAdultsInitialEncounterType().getEncounterTypeId(),
                    outpatientMetadata.getAdultReturnEncounterType().getEncounterTypeId(),
                    outpatientMetadata.getPedsInitialEncounterType().getEncounterTypeId(),
                    outpatientMetadata.getPedsReturnEncounterType().getEncounterTypeId(),
                    outpatientMetadata.getCheckInEncounterType().getEncounterTypeId(),
                    outpatientMetadata.getAncEncounterType().getEncounterTypeId(),
                    outpatientMetadata.getSpecialClinicConcept().getConceptId(),
                    answer));
    return cd;
  }

}

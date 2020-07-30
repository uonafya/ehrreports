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
import org.openmrs.module.ehrreports.reporting.calculation.CombinedStateCalculation;
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

  /**
   * Get patients who are queued as casuality during facility visit
   *
   * @return
   */
  public CohortDefinition getPatientsQueuedAsCasuality() {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Casuality Patients");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh717Queries.getPatientsGeneralQuery(
            outpatientMetadata.getTriageConcept().getConceptId(),
            outpatientMetadata.getOpdWardConcept().getConceptId(),
            outpatientMetadata.getCasualityOpdConcept().getConceptId(),
            outpatientMetadata.getCasualityTriageConcept().getConceptId()));
    return cd;
  }

  public CohortDefinition getRevisitPatientStates(EhrReportConstants.OccurenceStates state) {
    CalculationCohortDefinition cd =
        new CalculationCohortDefinition(
            "Returning Patients",
            Context.getRegisteredComponents(CombinedStateCalculation.class).get(0));
    cd.addParameter(new Parameter("onOrBefore", "End Date", Date.class));
    cd.addCalculationParameter("state", state);
    return cd;
  }

  /**
   * Get base query for the female patients in MCH
   *
   * @return CohortDefinition
   */
  public CohortDefinition getMchBaseCohortPatients(int program) {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("MCH Patients");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh717Queries.getMchBaseQueries(
            outpatientMetadata.getTriageConcept().getConceptId(),
            outpatientMetadata.getSpecialClinicConcept().getConceptId(),
            outpatientMetadata.getMchClinicConcept().getConceptId(),
            program));
    return cd;
  }

  /**
   * Get base query for the female patients in FP
   *
   * @return CohortDefinition
   */
  public CohortDefinition getFpBaseCohortPatients() {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("FP Patients");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh717Queries.getFpBaseQueries(
            outpatientMetadata.getSpecialClinicConcept().getConceptId(),
            outpatientMetadata.getMchClinicConcept().getConceptId()));
    return cd;
  }

  /**
   * Get all patients who attended dental clinic Both from OPD to special clinic
   *
   * @return CohortDefinition
   */
  public CohortDefinition getTotalDentalVisits() {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Dental clinic Patients");
    cd.addParameter(new Parameter("startDate", "StartDate", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh717Queries.getPatientsGeneralQuery(
            outpatientMetadata.getOpdWardConcept().getConceptId(),
            outpatientMetadata.getSpecialClinicConcept().getConceptId(),
            outpatientMetadata.getDentalClinicConcept().getConceptId(),
            outpatientMetadata.getDentalOpdConcept().getConceptId()));
    return cd;
  }
}

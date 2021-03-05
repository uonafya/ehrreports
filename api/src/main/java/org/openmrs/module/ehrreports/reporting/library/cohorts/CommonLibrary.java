/**
 * The contents of this file are subject to the OpenMRS Public License Version 1.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the
 * License at http://license.openmrs.org
 *
 * <p>Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF
 * ANY KIND, either express or implied. See the License for the specific language governing rights
 * and limitations under the License.
 *
 * <p>Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.ehrreports.reporting.library.cohorts;

import java.util.Arrays;
import java.util.Date;
import org.openmrs.Concept;
import org.openmrs.EncounterType;
import org.openmrs.api.PatientSetService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ehrreports.reporting.calculation.EncountersBasedOnDaySuppliedCalculation;
import org.openmrs.module.kenyacore.report.cohort.definition.CalculationCohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CodedObsCohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.EncounterCohortDefinition;
import org.openmrs.module.reporting.common.SetComparator;
import org.openmrs.module.reporting.common.TimeQualifier;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.stereotype.Component;

@Component
public class CommonLibrary {

  /**
   * Patients who have an encounter between ${onOrAfter} and ${onOrBefore}
   *
   * @param types the encounter types
   * @return the cohort definition
   */
  public CohortDefinition hasEncounter(EncounterType... types) {
    EncounterCohortDefinition cd = new EncounterCohortDefinition();
    cd.setName("has encounter between dates");
    cd.setTimeQualifier(TimeQualifier.ANY);
    cd.addParameter(new Parameter("onOrBefore", "Before Date", Date.class));
    cd.addParameter(new Parameter("onOrAfter", "After Date", Date.class));
    if (types.length > 0) {
      cd.setEncounterTypeList(Arrays.asList(types));
    }
    return cd;
  }

  /**
   * Patients who have an obs between ${onOrAfter} and ${onOrBefore}
   *
   * @param question the question concept
   * @param answers the answers to include
   * @return the cohort definition
   */
  public CohortDefinition hasObs(Concept question, Concept... answers) {
    CodedObsCohortDefinition cd = new CodedObsCohortDefinition();
    cd.setName("has obs between dates");
    cd.setQuestion(question);
    cd.setOperator(SetComparator.IN);
    cd.setTimeModifier(PatientSetService.TimeModifier.ANY);
    cd.addParameter(new Parameter("onOrBefore", "Before Date", Date.class));
    cd.addParameter(new Parameter("onOrAfter", "After Date", Date.class));
    if (answers.length > 0) {
      cd.setValueList(Arrays.asList(answers));
    }
    return cd;
  }

  /**
   * Patients who have encounters on date
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getPatientsHavingEncountersOnDate(int day) {
    CalculationCohortDefinition cd =
        new CalculationCohortDefinition(
            "Encounters per day",
            Context.getRegisteredComponents(EncountersBasedOnDaySuppliedCalculation.class).get(0));
    cd.addParameter(new Parameter("onOrBefore", "On or before Date", Date.class));
    cd.addParameter(new Parameter("onOrAfter", "On or After Date", Date.class));
    cd.addCalculationParameter("day", day);
    return cd;
  }
}

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
package org.openmrs.module.ehrreports.reporting.library.cohorts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openmrs.Location;
import org.openmrs.Program;
import org.openmrs.module.ehrreports.reporting.library.queries.CommonQueries;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.InProgramCohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.definition.library.DocumentedDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.stereotype.Component;

@Component
public class GenericCohortQueries {

  /**
   * Generic SQL cohort
   *
   * @return CohortDefinition
   */
  @DocumentedDefinition(value = "generalSql")
  public CohortDefinition generalSql(String name, String query) {
    SqlCohortDefinition sql = new SqlCohortDefinition();
    sql.setName(name);
    sql.addParameter(new Parameter("startDate", "Start Date", Date.class));
    sql.addParameter(new Parameter("endDate", "End Date", Date.class));
    sql.setQuery(query);
    return sql;
  }

  /**
   * Generic InProgram Cohort
   *
   * @param program the programs
   * @return the cohort definition
   */
  public CohortDefinition createInProgram(String name, Program program) {
    InProgramCohortDefinition inProgram = new InProgramCohortDefinition();
    inProgram.setName(name);

    List<Program> programs = new ArrayList<Program>();
    programs.add(program);

    inProgram.setPrograms(programs);
    inProgram.addParameter(new Parameter("onOrBefore", "Before Date", Date.class));
    inProgram.addParameter(new Parameter("locations", "Location", Location.class));
    return inProgram;
  }

  /**
   * Get the base patients for our results, we don't need to have all patients
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getBaseCohort() {
    return generalSql("Base cohort", CommonQueries.patientsHavingEncountersBetweenDateBaseCohort());
  }
}

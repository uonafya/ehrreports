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
import org.openmrs.module.ehrreports.metadata.EhrOutpatientMetadata;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabResultsCohortQueries {

  @Autowired private EhrOutpatientMetadata outpatientMetadata;

  /**
   * Get the results performed on Lab tests
   *
   * @return @{@link org.openmrs.module.reporting.cohort.definition.CohortDefinition}tDefiniton
   */
  public CohortDefinition getLabResultsForAgivenPeriod() {
    SqlCohortDefinition sql = new SqlCohortDefinition();
    sql.setName("Lab results for the given period");
    sql.addParameter(new Parameter("startDate", "Start Date", Date.class));
    sql.addParameter(new Parameter("endDate", "End Date", Date.class));
    return sql;
  }
}

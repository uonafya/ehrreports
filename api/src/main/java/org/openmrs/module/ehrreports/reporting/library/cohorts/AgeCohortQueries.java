package org.openmrs.module.ehrreports.reporting.library.cohorts;

import java.util.Date;
import org.openmrs.module.reporting.cohort.definition.AgeCohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgeCohortQueries {

  @Autowired private GenericCohortQueries genericCohortQueries;

  public CohortDefinition createXtoYAgeCohort(String name, Integer minAge, Integer maxAge) {
    AgeCohortDefinition xToYCohort = new AgeCohortDefinition();
    xToYCohort.setName(name);
    if (minAge != null) {
      xToYCohort.setMinAge(minAge);
    }
    if (maxAge != null) {
      xToYCohort.setMaxAge(maxAge);
    }
    xToYCohort.addParameter(new Parameter("effectiveDate", "effectiveDate", Date.class));
    return xToYCohort;
  }

  /**
   * Person with Unknown age, the birthdate column is null
   *
   * @return CohortDefinition
   */
  public CohortDefinition createUnknownAgeCohort() {
    return genericCohortQueries.generalSql(
        "unknownAge",
        "SELECT p.patient_id FROM patient p JOIN person pr ON p.patient_id = pr.person_id WHERE pr.birthdate IS NULL");
  }
}

package org.openmrs.module.ehrreports.reporting.library.cohorts;

import java.util.Date;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
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
}

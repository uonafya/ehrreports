package org.openmrs.module.ehrreports.reporting.library.cohorts.special_clinic;

import java.util.Date;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.queries.special_clinic.SpecialClinicCohorts;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialClinicCohortQueries {
  @Autowired private OutpatientMetadata outPatientMetadata;

  /**
   * Find all patients
   *
   * @return @{@link org.openmrs.module.reporting.cohort.definition.CohortDefinition}
   */
  public CohortDefinition getAllSpecialClinicPatients() {
    SqlCohortDefinition sql = new SqlCohortDefinition();
    sql.setName("special clinic cohort");
    sql.addParameter(new Parameter("startDate", "Start Date", Date.class));
    sql.addParameter(new Parameter("endDate", "End Date", Date.class));
    sql.setQuery(
        SpecialClinicCohorts.getSpecialClinic(
            outPatientMetadata.getSpecialClinicConcept().getConceptId()));
    return sql;
  }
}

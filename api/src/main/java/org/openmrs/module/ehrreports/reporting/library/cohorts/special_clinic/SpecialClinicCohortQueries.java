package org.openmrs.module.ehrreports.reporting.library.cohorts.special_clinic;

import java.util.Date;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.queries.special_clinic.SpecialClinicCohorts;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CompositionCohortDefinition;
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
  public CohortDefinition getAllSpecialClinicPatients(int ans) {
    SqlCohortDefinition sql = new SqlCohortDefinition();
    sql.setName("special clinic cohort");
    sql.addParameter(new Parameter("startDate", "Start Date", Date.class));
    sql.addParameter(new Parameter("endDate", "End Date", Date.class));
    sql.setQuery(
        SpecialClinicCohorts.getSpecialClinic(
            outPatientMetadata.getSpecialClinicConcept().getConceptId(), ans));
    return sql;
  }

  private CohortDefinition getAllVisitsNew() {
    SqlCohortDefinition sql = new SqlCohortDefinition();
    sql.setName("Get all  new visits per facility");
    sql.addParameter(new Parameter("startDate", "Start Date", Date.class));
    sql.addParameter(new Parameter("endDate", "End Date", Date.class));
    sql.setQuery(
        SpecialClinicCohorts.getAllVisits(
            outPatientMetadata.getNewPatientConcept().getConceptId()));
    return sql;
  }

  public CohortDefinition getAllVisitsRevisit() {
    SqlCohortDefinition sql = new SqlCohortDefinition();
    sql.setName("Get all revisit per facility");
    sql.addParameter(new Parameter("startDate", "Start Date", Date.class));
    sql.addParameter(new Parameter("endDate", "End Date", Date.class));
    sql.setQuery(
        SpecialClinicCohorts.getAllVisits(outPatientMetadata.getRevisitConcept().getConceptId()));
    return sql;
  }

  public CohortDefinition getNewPatientsOnly() {
    CompositionCohortDefinition cd = new CompositionCohortDefinition();
    cd.setName("New patients only within the facility");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.addSearch(
        "N", EhrReportUtils.map(getAllVisitsNew(), "startDate=${startDate},endDate=${endDate}"));
    cd.addSearch(
        "R",
        EhrReportUtils.map(getAllVisitsRevisit(), "startDate=${startDate},endDate=${endDate}"));
    cd.setCompositionString("N AND NOT R");
    return cd;
  }
}

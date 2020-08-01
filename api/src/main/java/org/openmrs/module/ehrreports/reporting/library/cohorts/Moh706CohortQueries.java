package org.openmrs.module.ehrreports.reporting.library.cohorts;

import java.util.Date;
import java.util.List;
import org.openmrs.module.ehrreports.metadata.LabTestsMetadata;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.library.indicators.EhrGeneralIndicator;
import org.openmrs.module.ehrreports.reporting.library.queries.moh706.Moh706Queries;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh706CohortQueries {

  @Autowired private OutpatientMetadata outpatientMetadata;
  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;
  @Autowired LabTestsMetadata labTestsMetadata;

  /**
   * Get all lab orders based on a given list of lab test concepts - MOH706 this method is generic
   * to pull all tests when supplied with a list of concepts
   *
   * @return @{@link org.openmrs.module.reporting.cohort.definition.CohortDefinition}
   */
  public CohortDefinition getAllLabOrdersForListOfLabConcepts(List<Integer> list) {
    SqlCohortDefinition cd = new SqlCohortDefinition();
    cd.setName("Get all lab orders placed based on a list of Lab concepts");
    cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
    cd.addParameter(new Parameter("endDate", "End Date", Date.class));
    cd.setQuery(
        Moh706Queries.getLabOrdersThatMatchTestsBasedOnConcepts(
            outpatientMetadata.getTestConceptClass().getConceptClassId(), list));
    return cd;
  }

  /**
   * Get all patients who have typhoid test during period of the month
   *
   * @return @{@link CohortDefinition}
   */
  public CohortDefinition getAllTyphoidTests() {

    return getAllLabOrdersForListOfLabConcepts(labTestsMetadata.getTyphoidTestConceptList());
  }
}

package org.openmrs.module.ehrreports.reporting.library.dimensions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.openmrs.module.ehrreports.reporting.library.cohorts.AgeCohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Uses {@link AgeCohortQueries} */
@Component("commonAgeDimensionCohort")
public class CommonAgeDimensionCohort implements AgeDimensionCohortInterface {

  @Autowired private AgeCohortQueries ageCohortQueries;

  @Override
  public Mapped<CohortDefinition> createXtoYAgeCohort(String name, Integer minAge, Integer maxAge) {
    CohortDefinition ageCohort = ageCohortQueries.createXtoYAgeCohort(name, minAge, maxAge);
    return EhrReportUtils.map(ageCohort, "effectiveDate=${effectiveDate}");
  }

  @Override
  public Mapped<CohortDefinition> createUnknownAgeCohort() {
    CohortDefinition ageCohort = ageCohortQueries.createUnknownAgeCohort();
    return EhrReportUtils.map(ageCohort, "");
  }

  @Override
  public List<Parameter> getParameters() {
    return Arrays.asList(new Parameter("effectiveDate", "effectiveDate", Date.class));
  }
}

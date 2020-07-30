package org.openmrs.module.ehrreports.reporting.calculation;

import java.util.Collection;
import java.util.Map;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;

public class CombinedStateCalculation extends AbstractPatientCalculation {

  @Override
  public CalculationResultMap evaluate(
      Collection<Integer> cohort,
      Map<String, Object> parameterValues,
      PatientCalculationContext context) {
    CalculationResultMap resultMap = new CalculationResultMap();

    for (Integer pId : cohort) {
      boolean isCandidate = false;
      resultMap.put(pId, new BooleanResult(isCandidate, this));
    }
    return resultMap;
  }
}

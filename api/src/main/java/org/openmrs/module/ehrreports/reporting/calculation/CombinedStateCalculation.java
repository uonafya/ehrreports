package org.openmrs.module.ehrreports.reporting.calculation;

import static org.openmrs.module.kenyacore.calculation.CalculationUtils.patientsThatPass;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.springframework.stereotype.Component;

@Component
public class CombinedStateCalculation extends AbstractPatientCalculation {

  @Override
  public CalculationResultMap evaluate(
      Collection<Integer> cohort,
      Map<String, Object> parameterValues,
      PatientCalculationContext context) {
    CalculationResultMap resultMap = new CalculationResultMap();
    EhrReportConstants.OccurenceStates state =
        (EhrReportConstants.OccurenceStates) parameterValues.get("state");
    RevisitPatientOccurenceCalculation revisitCalculation =
        Context.getRegisteredComponents(RevisitPatientOccurenceCalculation.class).get(0);
    NewPatientOccurenceCalculation newPatientsCalculation =
        Context.getRegisteredComponents(NewPatientOccurenceCalculation.class).get(0);
    Set<Integer> revisits = patientsThatPass(calculate(revisitCalculation, cohort, context));
    Set<Integer> newPatients = patientsThatPass(calculate(newPatientsCalculation, cohort, context));

    for (Integer pId : cohort) {
      boolean isCandidate = false;
      if ((state.equals(EhrReportConstants.OccurenceStates.REVISIT)) && revisits.contains(pId)) {
        isCandidate = true;
      } else if ((state.equals(EhrReportConstants.OccurenceStates.NEW))
          && newPatients.contains(pId)) {
        isCandidate = true;
      }
      resultMap.put(pId, new BooleanResult(isCandidate, this));
    }
    return resultMap;
  }
}

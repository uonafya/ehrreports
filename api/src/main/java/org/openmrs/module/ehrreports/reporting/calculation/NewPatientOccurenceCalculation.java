package org.openmrs.module.ehrreports.reporting.calculation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.ListResult;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.utils.EhrCalculationUtils;

public class NewPatientOccurenceCalculation extends AbstractPatientCalculation {

  @Override
  public CalculationResultMap evaluate(
      Collection<Integer> cohort,
      Map<String, Object> parameterValues,
      PatientCalculationContext context) {
    EhrCalculationService ehrCalculationService =
        Context.getRegisteredComponents(EhrCalculationService.class).get(0);
    // External dependencies
    OutpatientMetadata outpatientMetadata =
        Context.getRegisteredComponents(OutpatientMetadata.class).get(0);
    EncounterType regReturn = outpatientMetadata.getRegReturnEncounterType();
    EncounterType regInitial = outpatientMetadata.getRegInitialEncounterType();
    CalculationResultMap resultMap = new CalculationResultMap();
    // get those patients already having revisits and have been active

    RevisitPatientOccurenceCalculation revisitCalculation =
        Context.getRegisteredComponents(RevisitPatientOccurenceCalculation.class).get(0);
    Set<Integer> revisitAndActive =
        patientsThatPass(calculate(revisitCalculation, cohort, context));

    CalculationResultMap allEncounters =
        ehrCalculationService.allEncounters(
            Arrays.asList(regReturn, regInitial), cohort, null, context.getNow(), context);
    for (Integer pId : cohort) {
      boolean isCandidate = false;
      ListResult listResult = (ListResult) allEncounters.get(pId);
      List<Encounter> encounterList = EhrCalculationUtils.extractResultValues(listResult);
      if (encounterList.size() > 0 && !(revisitAndActive.contains(pId))) {
        for (Encounter encounter : encounterList) {
          if (encounter.getEncounterType().equals(regInitial)
              || encounter.getEncounterDatetime().compareTo(context.getNow()) > 0) {
            isCandidate = true;
            break;
          }
        }
      }
      resultMap.put(pId, new BooleanResult(isCandidate, this));
    }
    return resultMap;
  }
}

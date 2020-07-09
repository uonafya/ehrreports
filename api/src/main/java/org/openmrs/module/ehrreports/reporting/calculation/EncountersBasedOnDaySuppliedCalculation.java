package org.openmrs.module.ehrreports.reporting.calculation;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.openmrs.Encounter;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.ListResult;
import org.openmrs.module.ehrreports.reporting.utils.EhrCalculationUtils;
import org.springframework.stereotype.Component;

@Component
public class EncountersBasedOnDaySuppliedCalculation extends AbstractPatientCalculation {

  @Override
  public CalculationResultMap evaluate(
      Collection<Integer> cohort,
      Map<String, Object> parameterValues,
      PatientCalculationContext context) {
    CalculationResultMap resultMap = new CalculationResultMap();
    EhrCalculationService ehrCalculationService =
        Context.getRegisteredComponents(EhrCalculationService.class).get(0);
    Integer day = (Integer) parameterValues.get("day");
    Date startDate = (Date) context.getFromCache("onOrAfter");
    Date endDate = (Date) context.getFromCache("onOrBefore");
    System.out.println("Start Date is >>." + startDate + " and end date is >>" + endDate);
    CalculationResultMap allEncounters =
        ehrCalculationService.allEncounters(null, cohort, startDate, endDate, context);
    for (Integer pId : cohort) {
      boolean found = false;
      ListResult listResult = (ListResult) allEncounters.get(pId);
      List<Encounter> encounterList = EhrCalculationUtils.extractResultValues(listResult);
      for (Encounter encounter : encounterList) {
        if (day != null
            && endDate != null
            && encounter.getEncounterDatetime().equals(getDateBasedOnValue(endDate, day))) {
          found = true;
        }
      }
      resultMap.put(pId, new BooleanResult(found, this));
    }
    return resultMap;
  }

  private Date getDateBasedOnValue(Date date, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, day);

    return calendar.getTime();
  }
}

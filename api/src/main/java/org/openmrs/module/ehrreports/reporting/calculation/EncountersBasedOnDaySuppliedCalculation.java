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
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.reporting.common.TimeQualifier;
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
    Date startDate = null;
    Date endDate = (Date) context.getFromCache("onOrBefore");
    if (endDate != null) {
      startDate = getDateAdayEarlier(getDateBasedOnValue(endDate, 1), -1);
    }
    CalculationResultMap allEncounters =
        ehrCalculationService.allEncounters(
            null, cohort, startDate, endDate, TimeQualifier.ANY, context);
    for (Integer pId : cohort) {
      boolean found = false;
      ListResult listResult = (ListResult) allEncounters.get(pId);
      List<Encounter> encounterList = EhrCalculationUtils.extractResultValues(listResult);
      for (Encounter encounter : encounterList) {
        if (day != null
            && endDate != null
            && EhrReportUtils.formatDate(encounter.getEncounterDatetime())
                .equals(EhrReportUtils.formatDate(getDateBasedOnValue(endDate, day)))) {
          found = true;
          break;
        }
      }
      resultMap.put(pId, new BooleanResult(found, this));
    }
    return resultMap;
  }

  private Date getDateBasedOnValue(Date date, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);

    Calendar calendar1 = Calendar.getInstance();
    calendar1.set(year, month, day);

    return calendar1.getTime();
  }

  private Date getDateAdayEarlier(Date date, int days) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, days);
    return calendar.getTime();
  }
}

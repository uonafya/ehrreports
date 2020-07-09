package org.openmrs.module.ehrreports.reporting.library.queries;

import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;

public class CommonQueries {
  /**
   * Get patients who have encounters on a given date
   *
   * @return String
   */
  public static String patientsHavingEncountersOnDate(int day) {
    return "SELECT p.patient_id FROM patient p INNER JOIN encounter e ON p.patient_id=e.patient_id "
        + " WHERE p.voided= 0 AND e.voided=0 AND1 e.encounter_datetime="
        + EhrReportUtils.getTheDateBasedOnIntegerSupplied(":endDate", day)
        + " AND ";
  }
}

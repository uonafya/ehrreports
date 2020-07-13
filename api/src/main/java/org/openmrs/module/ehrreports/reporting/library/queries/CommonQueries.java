package org.openmrs.module.ehrreports.reporting.library.queries;

public class CommonQueries {
  /**
   * Get patients who have encounters on a given date
   *
   * @return String
   */
  public static String patientsHavingEncountersBetweenDateBaseCohort() {
    return "SELECT p.patient_id FROM patient p INNER JOIN encounter e ON p.patient_id=e.patient_id "
        + " WHERE p.voided= 0 AND e.voided=0 AND e.encounter_datetime BETWEEN :startDate AND :endDate ";
  }
}

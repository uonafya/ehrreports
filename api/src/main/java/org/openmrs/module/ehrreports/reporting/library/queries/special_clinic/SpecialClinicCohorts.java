package org.openmrs.module.ehrreports.reporting.library.queries.special_clinic;

public class SpecialClinicCohorts {

  public static final String getSpecialClinic(int conceptId, int ans) {
    String sql =
        "SELECT p.patient_id FROM patient p INNER JOIN encounter e ON p.patient_id=e.patient_id INNER JOIN "
            + "obs o ON e.encounter_id=o.encounter_id WHERE o.concept_id=%d AND e.encounter_datetime "
            + "BETWEEN :startDate AND :endDate AND p.voided=0 AND e.voided=0 AND o.voided=0 AND o.value_coded=%d";
    return String.format(sql, conceptId, ans);
  }
}

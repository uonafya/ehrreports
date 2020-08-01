package org.openmrs.module.ehrreports.reporting.library.queries.moh706;

import java.util.List;

public class Moh706Queries {

  public static String getLabOrdersThatMatchTestsBasedOnConcepts(
      int classId, List<Integer> listOptions) {
    String str1 = String.valueOf(listOptions).replaceAll("\\[", "");
    String list = str1.replaceAll("]", "");
    String query =
        "SELECT pat.patient_id FROM patient pat "
            + " INNER JOIN person pe ON pat.patient_id=pe.person_id "
            + " INNER JOIN encounter e ON pat.patient_id=e.patient_id "
            + " INNER JOIN obs ob ON e.encounter_id=ob.encounter_id "
            + " INNER JOIN concept c ON c.concept_id=ob.value_coded "
            + " WHERE "
            + " e.encounter_datetime BETWEEN DATE_ADD(:startDate, interval -1 DAY) AND DATE_ADD(:endDate, interval 1 DAY) "
            + " AND ob.value_coded IS NOT NULL "
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) < 5 "
            + " AND c.class_id IN(%d) "
            + " AND ob.value_coded IN(%s)";
    return String.format(query, classId, list);
  }
}

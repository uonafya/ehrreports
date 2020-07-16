/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ehrreports.reporting.library.queries.moh705;

import java.util.List;

public class Moh705Queries {

  /**
   * put you first indicator query here MOH 705a
   *
   * @return String
   */
  public static String getMoh705aQuery(int classId) {
    String sql =
        "SELECT "
            + " cn.name AS Diagnosis, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 1 THEN 1 ELSE 0 END) AS 1st, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 2 THEN 1 ELSE 0 END) AS 2nd, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 3 THEN 1 ELSE 0 END) AS 3rd, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 4 THEN 1 ELSE 0 END) AS 4th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 5 THEN 1 ELSE 0 END) AS 5th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 6 THEN 1 ELSE 0 END) AS 6th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 7 THEN 1 ELSE 0 END) AS 7th,"
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 8 THEN 1 ELSE 0 END) AS 8th,"
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 9 THEN 1 ELSE 0 END) AS 9th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 10 THEN 1 ELSE 0 END) AS 10th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 11 THEN 1 ELSE 0 END) AS 11th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 12 THEN 1 ELSE 0 END) AS 12th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 13 THEN 1 ELSE 0 END) AS 13th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 14 THEN 1 ELSE 0 END) AS 14th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 15 THEN 1 ELSE 0 END) AS 15th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 16 THEN 1 ELSE 0 END) AS 16th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 17 THEN 1 ELSE 0 END) AS 17th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 18 THEN 1 ELSE 0 END) AS 18th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 19 THEN 1 ELSE 0 END) AS 19th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 20 THEN 1 ELSE 0 END) AS 20th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 21 THEN 1 ELSE 0 END) AS 21st, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 22 THEN 1 ELSE 0 END) AS 22nd, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 23 THEN 1 ELSE 0 END) AS 23rd, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 24 THEN 1 ELSE 0 END) AS 24th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 25 THEN 1 ELSE 0 END) AS 25th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 26 THEN 1 ELSE 0 END) AS 26th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 27 THEN 1 ELSE 0 END) AS 27th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 28 THEN 1 ELSE 0 END) AS 28th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 29 THEN 1 ELSE 0 END) AS 29th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 30 THEN 1 ELSE 0 END) AS 30th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 31 THEN 1 ELSE 0 END) AS 31st "
            + " FROM obs o "
            + " INNER JOIN encounter e ON o.encounter_id = e.encounter_id "
            + " INNER JOIN person pe ON e.patient_id=pe.person_id "
            + "INNER JOIN concept_name cn ON cn.concept_id = o.value_coded AND locale = 'en' AND cn.locale_preferred = 1 "
            + "INNER JOIN concept c ON c.concept_id=cn.concept_id "
            + "WHERE "
            + " e.encounter_datetime BETWEEN DATE_ADD(:startDate, interval 0 DAY) AND DATE_ADD(:endDate, interval 1 DAY) "
            + " AND o.value_coded IS NOT NULL "
            + " AND c.class_id IN(%d) "
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) < 5 "
            + "GROUP BY cn.name";

    return String.format(sql, classId);
  }

  /**
   * put you first indicator query here MOH 705b
   *
   * @return String
   */
  public static String getMoh705bQuery(int classId) {
    String sql =
        "SELECT "
            + " cn.name AS Diagnosis, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 1 THEN 1 ELSE 0 END) AS 1st, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 2 THEN 1 ELSE 0 END) AS 2nd, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 3 THEN 1 ELSE 0 END) AS 3rd, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 4 THEN 1 ELSE 0 END) AS 4th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 5 THEN 1 ELSE 0 END) AS 5th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 6 THEN 1 ELSE 0 END) AS 6th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 7 THEN 1 ELSE 0 END) AS 7th,"
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 8 THEN 1 ELSE 0 END) AS 8th,"
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 9 THEN 1 ELSE 0 END) AS 9th, "
            + " SUM(CASE DAY(e.encounter_datetime) WHEN 10 THEN 1 ELSE 0 END) AS 10th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 11 THEN 1 ELSE 0 END) AS 11th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 12 THEN 1 ELSE 0 END) AS 12th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 13 THEN 1 ELSE 0 END) AS 13th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 14 THEN 1 ELSE 0 END) AS 14th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 15 THEN 1 ELSE 0 END) AS 15th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 16 THEN 1 ELSE 0 END) AS 16th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 17 THEN 1 ELSE 0 END) AS 17th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 18 THEN 1 ELSE 0 END) AS 18th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 19 THEN 1 ELSE 0 END) AS 19th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 20 THEN 1 ELSE 0 END) AS 20th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 21 THEN 1 ELSE 0 END) AS 21st, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 22 THEN 1 ELSE 0 END) AS 22nd, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 23 THEN 1 ELSE 0 END) AS 23rd, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 24 THEN 1 ELSE 0 END) AS 24th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 25 THEN 1 ELSE 0 END) AS 25th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 26 THEN 1 ELSE 0 END) AS 26th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 27 THEN 1 ELSE 0 END) AS 27th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 28 THEN 1 ELSE 0 END) AS 28th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 29 THEN 1 ELSE 0 END) AS 29th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 30 THEN 1 ELSE 0 END) AS 30th, "
            + "    SUM(CASE DAY(e.encounter_datetime) WHEN 31 THEN 1 ELSE 0 END) AS 31st "
            + " FROM obs o "
            + " INNER JOIN encounter e ON o.encounter_id = e.encounter_id "
            + " INNER JOIN person pe ON e.patient_id=pe.person_id "
            + "INNER JOIN concept_name cn ON cn.concept_id = o.value_coded AND locale = 'en' AND cn.locale_preferred = 1 "
            + "INNER JOIN concept c ON c.concept_id=cn.concept_id "
            + "WHERE "
            + " e.encounter_datetime BETWEEN DATE_ADD(:startDate, interval 0 DAY) AND DATE_ADD(:endDate, interval 1 DAY) "
            + " AND o.value_coded IS NOT NULL "
            + " AND c.class_id IN(%d) "
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) >= 5 "
            + "GROUP BY cn.name";

    return String.format(sql, classId);
  }
  /**
   * Get patients who conform to the diagnosis based on given concepts
   *
   * @return String of adults
   */
  public static String getAdultPatientsWhoMatchDiagnosisBasedOnConcepts(
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
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) >= 5 "
            + " AND c.class_id IN(%d) "
            + " AND ob.value_coded IN(%s)";
    return String.format(query, classId, list);
  }

  /**
   * Get patients who conform to the diagnosis based on given concepts
   *
   * @return String of children
   */
  public static String getChildrenPatientsWhoMatchDiagnosisBasedOnConcepts(
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

  /**
   * Get all children patients who have any diagnosis recorded for the period given
   *
   * @return String of query
   */
  public static String getChildrenPatientsWhoMatchDiagnosisAll(int classId) {
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
            + " AND c.class_id IN(%d) ";
    return String.format(query, classId);
  }

  /**
   * Get all adult patients who have any diagnosis recorded for the period given
   *
   * @return String of query
   */
  public static String getAdultsPatientsWhoMatchDiagnosisAll(int classId) {
    String query =
        "SELECT pat.patient_id FROM patient pat "
            + " INNER JOIN person pe ON pat.patient_id=pe.person_id "
            + " INNER JOIN encounter e ON pat.patient_id=e.patient_id "
            + " INNER JOIN obs ob ON e.encounter_id=ob.encounter_id "
            + " INNER JOIN concept c ON c.concept_id=ob.value_coded "
            + " WHERE "
            + " e.encounter_datetime BETWEEN DATE_ADD(:startDate, interval -1 DAY) AND DATE_ADD(:endDate, interval 1 DAY) "
            + " AND ob.value_coded IS NOT NULL "
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) >= 5 "
            + " AND c.class_id IN(%d) ";
    return String.format(query, classId);
  }

  /**
   * Get the BMI of the patients based on sql query
   *
   * @return String
   */
  public static String getAdultsPatientsWithGreaterThan25BMI() {
    String query =
        "SELECT patient_id FROM triage_patient_data WHERE created_on BETWEEN :startDate AND DATE_ADD(:endDate, interval 1 DAY) AND weight > 0 AND height > 0 AND ((100 * 100 * weight) / (height * height))>25";

    return query;
  }

  private static boolean getBMI(String w, String h) {
    double weight = Double.parseDouble(w);
    double height = Double.parseDouble(h);
    return (100 * 100 * weight) / (height * height) > 25;
  }
}

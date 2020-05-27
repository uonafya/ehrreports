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

public class Moh705aQueries {

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
            + " e.encounter_datetime BETWEEN :startDate AND :endDate "
            + " AND o.value_coded IS NOT NULL "
            + " AND c.class_id IN(%d) "
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) <= 5 "
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
            + " e.encounter_datetime BETWEEN :startDate AND :endDate "
            + " AND o.value_coded IS NOT NULL "
            + " AND c.class_id IN(%d) "
            + " AND TIMESTAMPDIFF(YEAR, pe.birthdate, :endDate) > 5 "
            + "GROUP BY cn.name";

    return String.format(sql, classId);
  }
}

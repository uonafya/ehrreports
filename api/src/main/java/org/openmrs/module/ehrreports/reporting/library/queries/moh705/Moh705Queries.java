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

public class Moh705Queries {

  /**
   * put you first indicator query here
   *
   * @return String
   */
  public static String getMoh705Query(int classId) {
    String sql =
        "SELECT "
            + " cn.name AS Diagnosis, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 1 THEN 1 ELSE 0 END) AS 1, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 2 THEN 1 ELSE 0 END) AS 2, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 3 THEN 1 ELSE 0 END) AS 3, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 4 THEN 1 ELSE 0 END) AS 4, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 5 THEN 1 ELSE 0 END) AS 5, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 6 THEN 1 ELSE 0 END) AS 6, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 7 THEN 1 ELSE 0 END) AS 7,"
            + " SUM(CASE DAY(encounter_datetime) WHEN 8 THEN 1 ELSE 0 END) AS 8,"
            + " SUM(CASE DAY(encounter_datetime) WHEN 9 THEN 1 ELSE 0 END) AS 9, "
            + " SUM(CASE DAY(encounter_datetime) WHEN 10 THEN 1 ELSE 0 END) AS 10, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 11 THEN 1 ELSE 0 END) AS 11, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 12 THEN 1 ELSE 0 END) AS 12, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 13 THEN 1 ELSE 0 END) AS 13, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 14 THEN 1 ELSE 0 END) AS 14, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 15 THEN 1 ELSE 0 END) AS 15, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 16 THEN 1 ELSE 0 END) AS 16, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 17 THEN 1 ELSE 0 END) AS 17, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 18 THEN 1 ELSE 0 END) AS 18, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 19 THEN 1 ELSE 0 END) AS 19, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 20 THEN 1 ELSE 0 END) AS 20, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 21 THEN 1 ELSE 0 END) AS 21, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 22 THEN 1 ELSE 0 END) AS 22, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 23 THEN 1 ELSE 0 END) AS 23, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 24 THEN 1 ELSE 0 END) AS 24, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 25 THEN 1 ELSE 0 END) AS 25, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 26 THEN 1 ELSE 0 END) AS 26, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 27 THEN 1 ELSE 0 END) AS 27, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 28 THEN 1 ELSE 0 END) AS 28, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 29 THEN 1 ELSE 0 END) AS 29, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 30 THEN 1 ELSE 0 END) AS 30, "
            + "    SUM(CASE DAY(encounter_datetime) WHEN 31 THEN 1 ELSE 0 END) AS 31 "
            + "FROM obs o "
            + "INNER JOIN encounter e ON o.encounter_id = e.encounter_id "
            + "INNER JOIN concept_name cn ON cn.concept_id = o.value_coded AND locale = 'en' AND cn.locale_preferred = 1 "
            + "INNER JOIN concept c ON c.concept_id=cn.concept_id "
            + "WHERE "
            + " e.encounter_datetime BETWEEN :startDate AND :endDate "
            + " AND o.value_coded IS NOT NULL "
            + " AND c.class_id IN(%d) -- Diagnosis class"
            + "GROUP BY cn.name";

    return String.format(sql, classId);
  }
}

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
package org.openmrs.module.ehrreports.reporting.library.queries.lab;

import java.util.List;

public class LabResultsQueries {
  /**
   * The lab results query will go here for the test to come up
   *
   * @return String
   */
  public static String getLabResultsQuery(List<Integer> conceptQuestionList) {
    String str1 = String.valueOf(conceptQuestionList).replaceAll("\\[", "");
    String list = str1.replaceAll("]", "");
    String sql =
        "SELECT "
            + " cn.name AS Investigation , "
            + " e.encounter_datetime AS Date, "
            + " o.value_numeric AS Numeric, "
            + " o.value_text AS Value, "
            + " o.value_coded, "
            + " o.value_datetime, "
            + " FROM obs o "
            + " INNER JOIN encounter e ON o.encounter_id = e.encounter_id "
            + " INNER JOIN person pe ON e.patient_id=pe.person_id "
            + " INNER JOIN person_name pn ON pe.person_id=pn.person_id "
            + " INNER JOIN concept_name cn ON cn.concept_id = o.value_coded AND locale = 'en' AND cn.locale_preferred = 1 "
            + " WHERE "
            + " e.encounter_datetime BETWEEN :startDate AND :endDate "
            + " AND o.concept_id IN(%s)";

    return String.format(sql, list);
  }
}

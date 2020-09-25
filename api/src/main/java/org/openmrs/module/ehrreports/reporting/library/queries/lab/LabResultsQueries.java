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

public class LabResultsQueries {
  /**
   * The lab results query will go here for the test to come up
   *
   * @return String
   */
  public static String getLabResultsQuery() {
    String sql =
        "SELECT "
            + " pn.given_name, "
            + " pn.family_name, "
            + " pi.identifier, "
            + " cn.name AS Investigation , "
            + " e.encounter_datetime, "
            + " o.value_coded, "
            + " o.value_numeric, "
            + " o.value_text, "
            + " o.comments"
            + " FROM obs o "
            + " INNER JOIN encounter e ON o.encounter_id = e.encounter_id "
            + " INNER JOIN concept_name cn ON cn.concept_id = o.concept_id "
            + " INNER JOIN person_name pn ON pn.person_id=o.person_id "
            + " INNER JOIN patient_identifier pi ON pi.patient_id=pn.person_id "
            + " INNER JOIN simplelabentry_labtest sl ON e.encounter_id=sl.encounter_id AND sl.concept_id=o.concept_id AND locale = 'en' AND cn.locale_preferred = 1 "
            + " WHERE "
            + " e.encounter_datetime BETWEEN :startDate AND :endDate ";

    return String.format(sql);
  }
}

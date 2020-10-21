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
   * The lab results query for the adults will go here for the test to come up
   *
   * @return String
   */
  public static String getLabAdultsResultsQuery() {
    String sql =
        "SELECT * FROM ("
            + "SELECT person_id, "
            + "       identifier,"
            + "       given_name, "
            + "       family_name, "
            + "       investigation, "
            + "       encounter_datetime, "
            + "       value_numeric, "
            + "       value_text, "
            + "       comments, "
            + "       name, "
            + "       result_text "
            + " FROM   (SELECT * "
            + "        FROM   (SELECT t1.given_name, "
            + "                       t1.person_id, "
            + "                       t1.encounter_id, "
            + "                       t1.family_name, "
            + "                       t1.identifier, "
            + "                       t1.investigation, "
            + "                       t1.encounter_datetime, "
            + "                       t1.value_numeric, "
            + "                       t1.value_text, "
            + "                       t1.comments "
            + "                FROM   (SELECT pn.given_name, "
            + "                               pn.person_id, "
            + "                               pn.family_name, "
            + "                               pi.identifier, "
            + "                               cn.name AS Investigation, "
            + "                               e.encounter_datetime, "
            + "                               o.value_numeric, "
            + "                               o.value_text, "
            + "                               o.value_coded, "
            + "                               o.comments, "
            + "                               e.encounter_id "
            + "                        FROM   obs o "
            + "                               INNER JOIN encounter e "
            + "                                       ON o.encounter_id = e.encounter_id "
            + "                               INNER JOIN concept_name cn "
            + "                                       ON cn.concept_id = o.concept_id "
            + "                               INNER JOIN person_name pn "
            + "                                       ON pn.person_id = o.person_id "
            + "                               INNER JOIN patient_identifier pi "
            + "                                       ON pi.patient_id = pn.person_id "
            + "                               INNER JOIN simplelabentry_labtest sl "
            + "                                       ON o.encounter_id = sl.encounter_id "
            + "                                          AND sl.concept_id = o.concept_id "
            + "                                          AND cn.locale = 'en' "
            + "                                          AND cn.locale_preferred = 1) t1)tn "
            + "               INNER JOIN (SELECT encounter_id AS enc_id, "
            + "                                  value_coded  AS result_value, "
            + "                                  value_text   AS result_text "
            + "                           FROM   obs)r1 "
            + "                       ON tn.encounter_id = r1.enc_id "
            + "        WHERE  encounter_datetime BETWEEN :startDate AND :endDate "
            + "               AND ( result_value <> '' "
            + "                      OR result_text <> '' "
            + "                      OR value_numeric <> '' "
            + "                      OR value_text <> '' "
            + "                      OR comments <> '' ))fn "
            + "       LEFT JOIN concept_name t2 "
            + "              ON t2.concept_id = fn.result_value "
            + "                 AND t2.locale = 'en' "
            + "                 AND t2.locale_preferred "
            + ") adults "
            + " WHERE adults.person_id IN ("
            + "SELECT person_id FROM person WHERE TIMESTAMPDIFF(YEAR, birthdate, :endDate) > 14) ";

    return String.format(sql);
  }

  /**
   * The lab results query for the adults will go here for the test to come up
   *
   * @return String
   */
  public static String getLabChildrenResultsQuery() {
    String sql =
        "SELECT * FROM ("
            + "SELECT person_id, "
            + "       identifier,"
            + "       given_name, "
            + "       family_name, "
            + "       investigation, "
            + "       encounter_datetime, "
            + "       value_numeric, "
            + "       value_text, "
            + "       comments, "
            + "       name, "
            + "       result_text "
            + " FROM   (SELECT * "
            + "        FROM   (SELECT t1.given_name, "
            + "                       t1.person_id, "
            + "                       t1.encounter_id, "
            + "                       t1.family_name, "
            + "                       t1.identifier, "
            + "                       t1.investigation, "
            + "                       t1.encounter_datetime, "
            + "                       t1.value_numeric, "
            + "                       t1.value_text, "
            + "                       t1.comments "
            + "                FROM   (SELECT pn.given_name, "
            + "                               pn.person_id, "
            + "                               pn.family_name, "
            + "                               pi.identifier, "
            + "                               cn.name AS Investigation, "
            + "                               e.encounter_datetime, "
            + "                               o.value_numeric, "
            + "                               o.value_text, "
            + "                               o.value_coded, "
            + "                               o.comments, "
            + "                               e.encounter_id "
            + "                        FROM   obs o "
            + "                               INNER JOIN encounter e "
            + "                                       ON o.encounter_id = e.encounter_id "
            + "                               INNER JOIN concept_name cn "
            + "                                       ON cn.concept_id = o.concept_id "
            + "                               INNER JOIN person_name pn "
            + "                                       ON pn.person_id = o.person_id "
            + "                               INNER JOIN patient_identifier pi "
            + "                                       ON pi.patient_id = pn.person_id "
            + "                               INNER JOIN simplelabentry_labtest sl "
            + "                                       ON o.encounter_id = sl.encounter_id "
            + "                                          AND sl.concept_id = o.concept_id "
            + "                                          AND cn.locale = 'en' "
            + "                                          AND cn.locale_preferred = 1) t1)tn "
            + "               INNER JOIN (SELECT encounter_id AS enc_id, "
            + "                                  value_coded  AS result_value, "
            + "                                  value_text   AS result_text "
            + "                           FROM   obs)r1 "
            + "                       ON tn.encounter_id = r1.enc_id "
            + "        WHERE  encounter_datetime BETWEEN :startDate AND :endDate "
            + "               AND ( result_value <> '' "
            + "                      OR result_text <> '' "
            + "                      OR value_numeric <> '' "
            + "                      OR value_text <> '' "
            + "                      OR comments <> '' ))fn "
            + "       LEFT JOIN concept_name t2 "
            + "              ON t2.concept_id = fn.result_value "
            + "                 AND t2.locale = 'en' "
            + "                 AND t2.locale_preferred "
            + ") children "
            + " WHERE children.person_id IN ("
            + "SELECT person_id FROM person  WHERE TIMESTAMPDIFF(YEAR, birthdate, :endDate) < 15)";

    return String.format(sql);
  }
}

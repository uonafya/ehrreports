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
package org.openmrs.module.ehrreports.reporting.library.queries.moh717;

public class Moh717Queries {

  /**
   * Outpatient query
   *
   * @return String
   */
  public static String getOutPatientClinicPatients(
      int ADULTINITIAL_OUTPATIENT,
      int ADULTRETURN_OUTPATIENT,
      int PEDSINITIAL_OUTPATIENT,
      int PEDSRETURN_OUTPATIENT,
      int REGINITIAL_OUTPATIENT,
      int REGREVISIT_OUTPATIENT,
      int OPDENCOUNTER_OUTPATIENT) {
    String sql =
        " SELECT p.patient_id FROM patient p INNER JOIN encounter e ON p.patient_id=e.patient_id "
            + " WHERE e.encounter_type in(%d, %d, %d, %d, %d, %d, %d) AND e.encounter_datetime BETWEEN :startDate AND :endDate AND p.voided=0 AND e.voided=0";

    return String.format(
        sql,
        ADULTINITIAL_OUTPATIENT,
        ADULTRETURN_OUTPATIENT,
        PEDSINITIAL_OUTPATIENT,
        PEDSRETURN_OUTPATIENT,
        REGINITIAL_OUTPATIENT,
        REGREVISIT_OUTPATIENT,
        OPDENCOUNTER_OUTPATIENT);
  }

  /**
   * Casuality query
   *
   * @return String
   */
  public static String getSpecialClinicPatients(
      int enc1,
      int enc2,
      int enc3,
      int enc4,
      int enc12,
      int enc19,
      int conceptsQsn,
      int conceptAns) {
    String sql =
        " SELECT p.patient_id FROM patient p INNER JOIN encounter e ON p.patient_id=e.patient_id INNER JOIN obs o "
            + " ON e.encounter_id=o.encounter_id WHERE e.encounter_type IN(%d, %d, %d, %d, %d, %d) AND "
            + " o.concept_id IN(%d) AND o.value_coded IN(%d) AND e.encounter_datetime BETWEEN :startDate AND :endDate ";
    return String.format(sql, enc1, enc2, enc3, enc4, enc12, enc19, conceptsQsn, conceptAns);
  }
}

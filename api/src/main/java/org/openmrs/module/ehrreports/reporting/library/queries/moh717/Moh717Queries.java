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
	 * put you first indicator query here
	 * 
	 * @return String
	 */
	public static String getOutPatientClinicPatients(int encounter1, int encounter2) {
		String sql = " SELECT p.patient_id FROM patient p INNER JOIN encounter e ON p.patient_id=e.patient_id "
		        + " WHERE e.encounter_type in(%d, %d) AND e.encounter_datetime BETWEEN :startDate AND :endDate ";
		
		return String.format(sql, encounter1, encounter2);
	}
}

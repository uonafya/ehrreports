/*
 * The contents of this file are subject to the OpenMRS Public License Version
 * 1.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.ehrreports.reporting.calculation;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.openmrs.EncounterType;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.ehrreports.reporting.utils.EhrCalculationUtils;
import org.openmrs.module.reporting.common.TimeQualifier;
import org.openmrs.module.reporting.data.patient.definition.EncountersForPatientDataDefinition;
import org.springframework.stereotype.Service;

@Service
public class EhrCalculationService {

  /**
   * Evaluates all encounters of a given type of each patient
   *
   * @param encounterTypes
   * @param cohort
   * @param onOrAfter
   * @param context
   * @return all encounters for the patients
   */
  public CalculationResultMap allEncounters(
      List<EncounterType> encounterTypes,
      Collection<Integer> cohort,
      Date onOrAfter,
      Date onOrBefore,
      PatientCalculationContext context) {
    EncountersForPatientDataDefinition def = new EncountersForPatientDataDefinition();
    def.setWhich(TimeQualifier.ANY);
    if (onOrAfter != null) {
      def.setOnOrAfter(onOrAfter);
    }
    def.setOnOrBefore(onOrBefore);
    if (encounterTypes != null) {
      def.setName("all encounters ");
      def.setTypes(encounterTypes);
    } else {
      def.setName("all encounters of any type");
    }
    return EhrCalculationUtils.evaluateWithReporting(def, cohort, null, null, context);
  }
}

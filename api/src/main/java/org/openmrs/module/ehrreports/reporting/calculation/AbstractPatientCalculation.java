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
package org.openmrs.module.ehrreports.reporting.calculation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.BaseCalculation;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.patient.PatientCalculationService;
import org.openmrs.calculation.result.CalculationResult;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.ResultUtil;

/** Abstract base class for patient calculations */
public abstract class AbstractPatientCalculation extends BaseCalculation
    implements PatientCalculation {

  /**
   * Extracts patients from calculation result map with matching results
   *
   * @param results calculation result map
   * @param requiredResult the required result value
   * @return the extracted patient ids
   */
  public static Set<Integer> patientsThatPass(CalculationResultMap results, Object requiredResult) {
    Set<Integer> ret = new HashSet<Integer>();
    for (Map.Entry<Integer, CalculationResult> e : results.entrySet()) {
      CalculationResult result = e.getValue();

      // If there is no required result, just check trueness of result, otherwise check result
      // matches required result
      if ((requiredResult == null && ResultUtil.isTrue(result))
          || (result != null && result.getValue().equals(requiredResult))) {
        ret.add(e.getKey());
      }
    }
    return ret;
  }

  /**
   * Extracts patients from calculation result map with non-false/empty results
   *
   * @param results calculation result map
   * @return the extracted patient ids
   */
  public static Set<Integer> patientsThatPass(CalculationResultMap results) {
    return patientsThatPass(results, null);
  }

  /**
   * Evaluates a given calculation on each patient
   *
   * @param calculation the calculation
   * @param cohort the patient ids
   * @param calculationContext the calculation context
   * @param parameterValues the parameter values
   * @return the calculation result map
   */
  protected static CalculationResultMap calculate(
      PatientCalculation calculation,
      Collection<Integer> cohort,
      Map<String, Object> parameterValues,
      PatientCalculationContext calculationContext) {
    return Context.getService(PatientCalculationService.class)
        .evaluate(cohort, calculation, parameterValues, calculationContext);
  }

  /**
   * Evaluates a given calculation on each patient
   *
   * @param calculation the calculation
   * @param cohort the patient ids
   * @param calculationContext the calculation context
   * @return the calculation result map
   */
  protected static CalculationResultMap calculate(
      PatientCalculation calculation,
      Collection<Integer> cohort,
      PatientCalculationContext calculationContext) {
    return calculate(calculation, cohort, new HashMap<String, Object>(), calculationContext);
  }
}

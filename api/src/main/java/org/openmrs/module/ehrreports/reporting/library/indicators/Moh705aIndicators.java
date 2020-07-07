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
package org.openmrs.module.ehrreports.reporting.library.indicators;

import java.util.List;
import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh705aCohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aIndicators {
  @Autowired private Moh705aCohortQueries moh705aCohortQueries;

  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  /**
   * Get patients who are adults and have diagnosis based on the concepts supplied
   *
   * @return CohortIndicator
   */
  public CohortIndicator getMoh705aPatients(List<Integer> list) {
    return ehrGeneralIndicator.getIndicator(
        "MOH705A",
        EhrReportUtils.map(
            moh705aCohortQueries.getAdultPatientsWhoHaveDiagnosis(list),
            "startDate=${startDate},endDate=${endDate}"));
  }
}

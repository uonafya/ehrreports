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
package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.indicators.Moh705aIndicators;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aDataset extends BaseDataSet {

  @Autowired private Moh705aIndicators moh705aIndicators;

  public DataSetDefinition constructMoh705aDataset() {

    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    String mappings = "startDate=${startDate},endDate=${endDate}";
    dsd.setName("MOH705A");
    dsd.addParameters(getParameters());

    dsd.addColumn(
        "1",
        "Diarrhoea",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDiarrhoea(), mappings),
        "");
    dsd.addColumn(
        "OTHERS",
        "All other diseases",
        EhrReportUtils.map(
            moh705aIndicators.getMoh705aPatientsHavingDiagnosisOtherThanTheOnesListed(), mappings),
        "");

    return dsd;
  }

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }
}

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

import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.queries.moh705.Moh705aQueries;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.SqlDataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aDataset extends BaseDataSet {
  @Autowired private OutpatientMetadata outpatientMetadata;

  public DataSetDefinition constructMoh705aDataset() {

    SqlDataSetDefinition dsd = new SqlDataSetDefinition();
    dsd.setName("MOH 705 A Data Set");
    dsd.addParameters(getParameters());
    dsd.setSqlQuery(
        Moh705aQueries.getMoh705aQuery(
            outpatientMetadata.getDiagnosisConceptClass().getConceptClassId()));
    return dsd;
  }

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }
}

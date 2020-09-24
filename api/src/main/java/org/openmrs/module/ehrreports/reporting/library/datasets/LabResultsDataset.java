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
import org.openmrs.module.ehrreports.reporting.library.queries.lab.LabResultsQueries;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.SqlDataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabResultsDataset extends BaseDataSet {

  @Autowired private OutpatientMetadata outpatientMetadata;

  public DataSetDefinition constructLabResultsDataset() {

    SqlDataSetDefinition dsd = new SqlDataSetDefinition();
    dsd.setName("LAB");
    dsd.addParameters(getParameters());
    dsd.setSqlQuery(LabResultsQueries.getLabResultsQuery());
    return dsd;
  }
}

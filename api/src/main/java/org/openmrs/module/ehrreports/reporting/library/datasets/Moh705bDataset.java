package org.openmrs.module.ehrreports.reporting.library.datasets;

import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.queries.moh705.Moh705aQueries;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.SqlDataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705bDataset extends BaseDataSet {
  @Autowired private OutpatientMetadata outpatientMetadata;

  public DataSetDefinition constructMoh705bDataset() {

    SqlDataSetDefinition dsd = new SqlDataSetDefinition();
    dsd.setName("MOH 705 B Data Set");
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

package org.openmrs.module.ehrreports.reporting.cohort.evaluator;

import java.util.Date;
import org.openmrs.annotation.Handler;
import org.openmrs.api.context.Context;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.DataSet;
import org.openmrs.module.reporting.dataset.DataSetColumn;
import org.openmrs.module.reporting.dataset.DataSetRow;
import org.openmrs.module.reporting.dataset.SimpleDataSet;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.evaluator.DataSetEvaluator;
import org.openmrs.module.reporting.evaluation.EvaluationContext;
import org.openmrs.module.reporting.evaluation.EvaluationException;

@Handler(supports = CustomConfigurationsDataDefinition.class)
public class CustomConfigurationsDataEvaluator implements DataSetEvaluator {

  @Override
  public DataSet evaluate(DataSetDefinition dataSetDefinition, EvaluationContext context)
      throws EvaluationException {

    CustomConfigurationsDataDefinition dsd = (CustomConfigurationsDataDefinition) dataSetDefinition;

    SimpleDataSet dataSet = new SimpleDataSet(dataSetDefinition, context);

    DataSetRow row = new DataSetRow();
    row.addColumnValue(
        new DataSetColumn("report_time", "time", String.class),
        EhrReportUtils.formatDateWithTime(new Date()));
    dataSet.addRow(row);
    row.addColumnValue(new DataSetColumn("name", "name", String.class), getHospitalName());
    dataSet.addRow(row);
    return dataSet;
  }

  private String getHospitalName() {
    return Context.getAdministrationService().getGlobalProperty("hospitalcore.hospitalName");
  }
}

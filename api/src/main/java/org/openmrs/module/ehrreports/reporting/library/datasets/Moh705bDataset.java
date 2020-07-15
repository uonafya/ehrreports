package org.openmrs.module.ehrreports.reporting.library.datasets;

import static org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils.getAdultChildrenColumns;

import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.library.indicators.Moh705bIndicators;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705bDataset extends BaseDataSet {
  @Autowired private OutpatientMetadata outpatientMetadata;
  @Autowired private EhrCommonDimension ehrCommonDimension;
  @Autowired private Moh705bIndicators moh705bIndicators;

  public DataSetDefinition constructMoh705bDataset() {

    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    dsd.addDimension(
        "day",
        EhrReportUtils.map(ehrCommonDimension.encountersOfMonthPerDay(), "endDate=${endDate}"));
    String mappings = "startDate=${startDate},endDate=${endDate}";
    dsd.setName("MOH705B");
    dsd.addParameters(getParameters());

    // other diseases that are not classified will go here
    addRow(
        dsd,
        "OTHERS",
        "All other diseases",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsOtherDiseasesThatAreNotClassified(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "66",
        "Number of first attendances adults",
        EhrReportUtils.map(
            moh705bIndicators.getNewAndRevisitPatients(EhrReportConstants.OccurenceStates.NEW),
            "endDate=${endDate}"),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "67",
        "Number of re attendances adults",
        EhrReportUtils.map(
            moh705bIndicators.getNewAndRevisitPatients(EhrReportConstants.OccurenceStates.REVISIT),
            "endDate=${endDate}"),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "68",
        "Referrals from other health facility adults",
        EhrReportUtils.map(moh705bIndicators.getPatientsReferredToFacility(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "69",
        "Referrals to other health facility adults",
        EhrReportUtils.map(moh705bIndicators.getPatientsReferredToExternalFacilities(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "1",
        "Diarrhoea",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithDiarrhoea(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "2",
        "TB",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithTuberclosis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "3",
        "Dysentery",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithDysentery(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "4",
        "Cholera",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithCholera(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "5",
        "Menongococcal Infections",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithMenongococcalInfectionsList(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "6",
        "Other Meningitis",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithOtherMeningitis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "7",
        "Tetanus",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithTetanus(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "8",
        "Poliomyelitis(AFP)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithPoliomyelitis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "9",
        "Chicken Pox)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithChickenPox(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "10",
        "Measles)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithMeasles(), mappings),
        getAdultChildrenColumns());
    return dsd;
  }

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }
}

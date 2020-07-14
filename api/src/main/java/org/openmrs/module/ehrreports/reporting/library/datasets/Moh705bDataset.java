package org.openmrs.module.ehrreports.reporting.library.datasets;

import static org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils.getAdultChildrenColumns;

import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.library.indicators.Moh705bIndicators;
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
    addRow(
        dsd,
        "11",
        "Hepatitis)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithHepatitis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "12",
        "Mumps)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithMumps(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "13",
        "Fevers)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithFevers(), mappings),
        getAdultChildrenColumns());
    // 14
    // 15
    addRow(
        dsd,
        "16",
        "Malaria In Pregnancy)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithMalariaInPregnancy(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "17",
        "Typhoid Fever)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithTyphoidFever(), mappings),
        getAdultChildrenColumns());
    // 18

    addRow(
        dsd,
        "19",
        "Urinary Tract Infection)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithUrinaryTractInfection(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "20",
        "Bilharzia)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithBilharzia(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "21",
        "Intestinal Worms)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithIntestinalWorms(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "22",
        "Malnutrition)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithMalnutrition(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "23",
        "Anaemia)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithAnaemia(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "24",
        "Eye Infections)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithEyeInfections(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "25",
        "Other Eye Conditions)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithOtherEyeConditions(), mappings),
        getAdultChildrenColumns());
    return dsd;
  }

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }
}

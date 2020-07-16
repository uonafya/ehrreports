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

    addRow(
        dsd,
        "14",
        "Malaria Provisional",
        EhrReportUtils.map(
            moh705bIndicators.getPatientsWithMalaria(outpatientMetadata.getProvisionalDiagnosis()),
            mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "15",
        "Malaria Confirmed",
        EhrReportUtils.map(
            moh705bIndicators.getPatientsWithMalaria(outpatientMetadata.getFinalDiagnosis()),
            mappings),
        getAdultChildrenColumns());
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
        "18",
        "Sexually Transmitted Infections)",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsWithSexuallyTransmittedInfections(), mappings),
        getAdultChildrenColumns());
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
    addRow(
        dsd,
        "26",
        "Ear Infections Conditions)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithEarInfectionsConditions(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "27",
        "Upper Respiratory Tract Infections)",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsWithUpperRespiratoryTractInfections(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "28",
        "Asthma)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithAsthma(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "29",
        "Pneumonia)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithPneumonia(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "30",
        "Other Disease of Respiratory System)",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsWithOtherDiseaseOfRespiratorySystem(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "31",
        "Abortion)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithAbortion(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "32",
        "Disease of Puerperium and Child Birth)",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsWithDiseaseOfPueperiumAndChildBirth(), mappings),
        getAdultChildrenColumns());
    // 33
    addRow(
        dsd,
        "33",
        "Hypertension)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithHypertension(), mappings),
        getAdultChildrenColumns());

    addRow(
        dsd,
        "41",
        "Other Injuries)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithOtherInjuries(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "42",
        "Sexual Assault)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithSexualAssault(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "43",
        "Violence related injuries)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithViolenceRelatedInjuries(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "44",
        "Burns)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithBurns(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "45",
        "Snake Bites)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithSnakeBites(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "46",
        "Dog Bites)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithDogBites(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "47",
        "Other Bites)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithOtherBites(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "48",
        "Diabetes)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithDiabetes(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "49",
        "Epilepsy)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithEpilepsy(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "50",
        "Newly Diagnosed HIV)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithNewlyDiagnosedHIV(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "51",
        "Brucellosis)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithBrucellosis(), mappings),
        getAdultChildrenColumns());

    addRow(
        dsd,
        "52",
        "Cardiovascular Condition)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithCardiovascularCondition(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "53",
        "Central Narvous System Condition)",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsWithOtherCentralNarvousSystemCondition(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "60",
        "Kalazar)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithKalazar(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "61",
        "Dracunculosis(Guinea Worm))",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithDracunculosis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "62",
        "Yellow Fever)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithYellowFever(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "63",
        "Viral Haemorrhagic Feverr)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithHaemorrhagicFever(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "64",
        "Plague)",
        EhrReportUtils.map(moh705bIndicators.getAdultsWithPlague(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "64",
        "Deaths Due To Road Traffic Injuries)",
        EhrReportUtils.map(
            moh705bIndicators.getAdultsWithDeathtsDueToRoadTrafficInjuries(), mappings),
        getAdultChildrenColumns());
    return dsd;
  }

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }
}

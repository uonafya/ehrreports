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

import static org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils.getAdultChildrenColumns;

import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.library.indicators.Moh705aIndicators;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Moh705aDataset extends BaseDataSet {

  @Autowired private Moh705aIndicators moh705aIndicators;

  @Autowired private EhrCommonDimension ehrCommonDimension;

  public DataSetDefinition constructMoh705aDataset() {

    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    dsd.addDimension(
        "day",
        EhrReportUtils.map(ehrCommonDimension.encountersOfMonthPerDay(), "endDate=${endDate}"));
    String mappings = "startDate=${startDate},endDate=${endDate}";
    dsd.setName("MOH705A");
    dsd.addParameters(getParameters());

    addRow(
        dsd,
        "1",
        "Diarrhoea",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDiarrhoea(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "2",
        "Tuberculosis",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingTuberculosis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "3",
        "Dyscentery bloody diarrhoea",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDysentery(), mappings),
        getAdultChildrenColumns());

    addRow(
        dsd,
        "4",
        "Cholera",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingCholera(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "5",
        "Meningococcal Meningitis",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingMeningococcalInfctions(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "27",
        "Tonsillitis",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingTonsillitis(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "28",
        "Pneumonia",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingPneumonia(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "29",
        "Other Dis. Of Respiratory System",
        EhrReportUtils.map(
            moh705aIndicators.getPatientsHavingOtherDiseaseOfRespiratorySystem(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "30",
        "Mental Disorders",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingMentalDisorders(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "31",
        "Dental Disorders",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDentalDisorders(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "32",
        "Jiggers Infestation",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingJiggersInfestation(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "33",
        "Disease Of The Skin",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDiseaseOfTheSkin(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "34",
        "Chromosomal Abnomalities",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingChromosomalAbnomalities(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "35",
        "Congenital Anomalies",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingCongenitalAnomalies(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "36",
        "Poisoning",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingPoisoning(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "37",
        "Road Traffic Injuries",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingRoadTrafficInjuries(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "38",
        "Other Injuries",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingOtherInjuries(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "39",
        "Sexual Assault",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingSexualAssault(), mappings),
        getAdultChildrenColumns());

    addRow(
        dsd,
        "40",
        "Burns",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingBurns(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "41",
        "Snake Bites",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingSnakeBites(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "42",
        "Dog Bites",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDogBites(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "43",
        "Other Bites",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingOtherBites(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "44",
        "Diabetes",
        EhrReportUtils.map(moh705aIndicators.getPatientsHavingDiabetes(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "OTHERS",
        "All other diseases",
        EhrReportUtils.map(
            moh705aIndicators.getMoh705aPatientsHavingDiagnosisOtherThanTheOnesListed(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "64",
        "Number of first attendances",
        EhrReportUtils.map(
            moh705aIndicators.getNewAndRevisitPatients(EhrReportConstants.OccurenceStates.NEW),
            "endDate=${endDate}"),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "65",
        "Number of re attendances",
        EhrReportUtils.map(
            moh705aIndicators.getNewAndRevisitPatients(EhrReportConstants.OccurenceStates.REVISIT),
            "endDate=${endDate}"),
        getAdultChildrenColumns());

    addRow(
        dsd,
        "66",
        "Referrals from other health facility",
        EhrReportUtils.map(moh705aIndicators.getPatientsReferredToFacility(), mappings),
        getAdultChildrenColumns());
    addRow(
        dsd,
        "67",
        "Referrals to other health facility",
        EhrReportUtils.map(moh705aIndicators.getPatientsReferredToExternalFacilities(), mappings),
        getAdultChildrenColumns());

    return dsd;
  }

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }
}

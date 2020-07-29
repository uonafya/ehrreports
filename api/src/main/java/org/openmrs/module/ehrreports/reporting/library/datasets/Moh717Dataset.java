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

import java.util.Arrays;
import java.util.List;
import org.openmrs.module.ehrreports.metadata.OutpatientMetadata;
import org.openmrs.module.ehrreports.reporting.cohort.definition.CustomConfigurationsDataDefinition;
import org.openmrs.module.ehrreports.reporting.library.cohorts.CommonLibrary;
import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh717CohortQueries;
import org.openmrs.module.ehrreports.reporting.library.dimensions.AgeDimensionCohortInterface;
import org.openmrs.module.ehrreports.reporting.library.dimensions.EhrCommonDimension;
import org.openmrs.module.ehrreports.reporting.library.indicators.EhrGeneralIndicator;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Moh717Dataset extends BaseDataSet {

  @Autowired private EhrCommonDimension ehrCommonDimension;

  @Autowired private EhrGeneralIndicator ehrGeneralIndicator;

  @Autowired private Moh717CohortQueries moh717CohortQueries;

  @Autowired private OutpatientMetadata outpatientMetadata;

  @Autowired private CommonLibrary commonLibrary;

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  public DataSetDefinition constructCustomDataset() {
    CustomConfigurationsDataDefinition df = new CustomConfigurationsDataDefinition();
    df.setName("Custom fields ");
    return df;
  }

  public DataSetDefinition constructMoh717Dataset() {

    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    String mappings = "startDate=${startDate},endDate=${endDate}";
    String obsMappings = "onOrAfter=${startDate},onOrBefore=${endDate}";
    dsd.setName("MOH 717 Data Set");
    dsd.addParameters(getParameters());
    // Tie dimensions to this data definition
    dsd.addDimension("gender", EhrReportUtils.map(ehrCommonDimension.gender(), ""));
    dsd.addDimension(
        "age",
        EhrReportUtils.map(ehrCommonDimension.age(ageDimensionCohort), "effectiveDate=${endDate}"));
    dsd.addDimension("state", EhrReportUtils.map(ehrCommonDimension.state(), "endDate=${endDate}"));
    // add your dataset here, construct it here
    addRow(
        dsd,
        "A",
        "OUTPATIENT SERVICES",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "OUTPATIENT SERVICES",
                EhrReportUtils.map(moh717CohortQueries.getOutPatients(), mappings)),
            mappings),
        getAdultChildrenColumns());
    // Casuality
    addRow(
        dsd,
        "CA",
        "Casuality CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "Casuality CLINIC",
                EhrReportUtils.map(moh717CohortQueries.getPatientsQueuedAsCasuality(), mappings)),
            mappings),
        getSpecialClinicsCategories());
    // Special clinic
    // ENT Clinic - Concept_id 5119
    addRow(
        dsd,
        "ENT",
        "ENT CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "ENT CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getENTClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // EYE Clinic - Concept_id 5118
    addRow(
        dsd,
        "EYE",
        "EYE CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "EYE CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getEYEClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // TB and  Leprosy Clinic
    addRow(
        dsd,
        "TBLP",
        "TB and Leprosy CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "TB and Leprosy CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getTbLeprosyClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // STI
    addRow(
        dsd,
        "STI",
        "STI CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "STI CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getSTIClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // CCC
    addRow(
        dsd,
        "CCC",
        "CCC CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "CCC CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getCccClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // Psy
    addRow(
        dsd,
        "Psy",
        "Psychiatry CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "Psychiatry CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getPsycthricClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // Orthopedic clinic
    addRow(
        dsd,
        "Ort",
        "Orthopedic CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "Orthopedic CLINIC",
                EhrReportUtils.map(
                    moh717CohortQueries.getSpecialClinicPatients(
                        outpatientMetadata.getOrthopedicClinicConcept().getConceptId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // other special clinics
    addRow(
        dsd,
        "Oher",
        "Other CLINIC",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "Other CLINIC",
                EhrReportUtils.map(
                    commonLibrary.hasObs(
                        outpatientMetadata.getSpecialClinicConcept(),
                        outpatientMetadata.getMopcMedicalClinicConcept(),
                        outpatientMetadata.getPopsPediatricClinicConcept(),
                        outpatientMetadata.getCccClinicConcept(),
                        outpatientMetadata.getMopsDmDiabeticClinicConcept(),
                        outpatientMetadata.getFnaClinicConcept(),
                        outpatientMetadata.getGpcClinicConcept(),
                        outpatientMetadata.getMchClinicConcept(),
                        outpatientMetadata.getMopsClinicConcept(),
                        outpatientMetadata.getPallativeClinicConcept(),
                        outpatientMetadata.getSurgicalClinicConcept(),
                        outpatientMetadata.getChestAndSkinClinicConcept(),
                        outpatientMetadata.getDentalClinicConcept(),
                        outpatientMetadata.getFamilyPlanningClinicConcept()),
                    obsMappings)),
            mappings),
        getSpecialClinicsCategories());
    // Family planning methods
    addRow(
        dsd,
        "FP",
        "Family Planning Services",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "Family Planning Services",
                EhrReportUtils.map(moh717CohortQueries.getFpBaseCohortPatients(), mappings)),
            mappings),
        getSpecialClinicsCategories());

    // MCH
    addRow(
        dsd,
        "ANC",
        "ANC Program",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "ANC Program",
                EhrReportUtils.map(
                    moh717CohortQueries.getMchBaseCohortPatients(
                        outpatientMetadata.getAncProgram().getProgramId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());

    addRow(
        dsd,
        "PNC",
        "PNC Program",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "PNC Program",
                EhrReportUtils.map(
                    moh717CohortQueries.getMchBaseCohortPatients(
                        outpatientMetadata.getPncProgram().getProgramId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());

    addRow(
        dsd,
        "CWC",
        "CWC Program",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "CWC Program",
                EhrReportUtils.map(
                    moh717CohortQueries.getMchBaseCohortPatients(
                        outpatientMetadata.getCwcProgram().getProgramId()),
                    mappings)),
            mappings),
        getSpecialClinicsCategories());
    // Dental clinic
    addRow(
        dsd,
        "DT",
        "Dental Clinic",
        EhrReportUtils.map(
            ehrGeneralIndicator.getIndicator(
                "Dental Clinic",
                EhrReportUtils.map(moh717CohortQueries.getTotalDentalVisits(), mappings)),
            mappings),
        getSpecialClinicsCategories());
    return dsd;
  }

  private List<ColumnParameters> getAdultChildrenColumns() {
    // Male
    ColumnParameters over5YearsMaleN =
        new ColumnParameters(
            "over5YMN", "Over 5 Years Male - NEW", "gender=M|age=5+|state=NEW", "01");
    ColumnParameters over5YearsMaleR =
        new ColumnParameters(
            "over5YMR", "Over 5 Years Male - REVISIT", "gender=M|age=5+|state=RVT", "02");
    ColumnParameters under5YearsMaleN =
        new ColumnParameters(
            "under5YMN", "Under 5 Years Male - NEW", "gender=M|age=<5|state=NEW", "03");
    ColumnParameters under5YearsMaleR =
        new ColumnParameters(
            "under5YMR", "Under 5 Years Male - REVISIT", "gender=M|age=<5|state=RVT", "04");
    ColumnParameters totalMale = new ColumnParameters("totalM", "Total Male", "gender=M", "05");
    // Female
    ColumnParameters over5YearsFemaleN =
        new ColumnParameters(
            "over5YFN", "Over 5 Years Female - NEW", "gender=F|age=5+|state=NEW", "06");
    ColumnParameters over5YearsFemaleR =
        new ColumnParameters(
            "over5YFR", "Over 5 Years Female - REVISIT", "gender=F|age=5+|state=RVT", "07");
    ColumnParameters under5YearsFemaleN =
        new ColumnParameters(
            "under5YFN", "Under 5 Years Female - NEW", "gender=F|age=<5|state=NEW", "08");
    ColumnParameters under5YearsFemaleR =
        new ColumnParameters(
            "under5YFR", "Under 5 Years Female - REVISIT", "gender=F|age=<5|state=RVT", "09");
    ColumnParameters over60YearsNew =
        new ColumnParameters("over60new", "Over 60 Years - NEW", "age=>60|state=NEW", "11");
    ColumnParameters over60YearsReattendance =
        new ColumnParameters("over60reatt", "Over 60 Years - REVISIT", "age=>60|state=RVT", "12");
    ColumnParameters totalFemale = new ColumnParameters("totalF", "Total Female", "gender=F", "10");
    return Arrays.asList(
        over5YearsMaleN,
        over5YearsMaleR,
        under5YearsMaleN,
        under5YearsMaleR,
        totalMale,
        over5YearsFemaleN,
        over5YearsFemaleR,
        under5YearsFemaleN,
        under5YearsFemaleR,
        over60YearsNew,
        over60YearsReattendance,
        totalFemale);
  }

  private List<ColumnParameters> getSpecialClinicsCategories() {
    ColumnParameters NEW_CASES = new ColumnParameters("new_cases", "NEW", "state=NEW", "01");
    ColumnParameters REVISIT_CASES =
        new ColumnParameters("revisit_cases", "REVISIT", "state=RVT", "02");
    ColumnParameters TOTAL_CASES = new ColumnParameters("total_cases", "Total", "", "03");
    return Arrays.asList(NEW_CASES, REVISIT_CASES, TOTAL_CASES);
  }

  private List<ColumnParameters> getMchClientsCategories() {
    ColumnParameters NEW_CASES = new ColumnParameters("new_cases", "NEW", "state=NEW", "01");
    ColumnParameters REVISIT_CASES =
        new ColumnParameters("revisit_cases", "REVISIT", "state=RVT", "02");
    ColumnParameters TOTAL_CASES = new ColumnParameters("total_cases", "Total", "", "03");
    return Arrays.asList(NEW_CASES, REVISIT_CASES, TOTAL_CASES);
  }
}

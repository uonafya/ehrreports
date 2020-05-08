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

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  public DataSetDefinition constructMoh717Dataset() {

    CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
    String mappings = "startDate=${startDate},endDate=${endDate}";
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
        totalFemale);
  }
}

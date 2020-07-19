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
package org.openmrs.module.ehrreports.reporting.library.dimensions;

import java.util.Date;
import org.openmrs.module.ehrreports.reporting.library.cohorts.CommonLibrary;
import org.openmrs.module.ehrreports.reporting.library.cohorts.GenderCohortQueries;
import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh717CohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.indicator.dimension.CohortDefinitionDimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EhrCommonDimension {

  @Autowired private GenderCohortQueries genderCohortQueries;

  @Autowired private Moh717CohortQueries moh717CohortQueries;

  @Autowired private CommonLibrary commonLibrary;

  /**
   * Gender dimension
   *
   * @return the {@link org.openmrs.module.reporting.indicator.dimension.CohortDimension}
   */
  public CohortDefinitionDimension gender() {
    CohortDefinitionDimension dim = new CohortDefinitionDimension();
    dim.setName("gender");
    dim.addCohortDefinition("M", EhrReportUtils.map(genderCohortQueries.maleCohort(), ""));
    dim.addCohortDefinition("F", EhrReportUtils.map(genderCohortQueries.femaleCohort(), ""));
    return dim;
  }

  /**
   * Age range dimension for <5 Years and >5 years
   *
   * @return {@link org.openmrs.module.reporting.indicator.dimension.CohortDimension}
   */
  public CohortDefinitionDimension age(AgeDimensionCohortInterface ageDimensionCohort) {
    CohortDefinitionDimension dim = new CohortDefinitionDimension();
    dim.setParameters(ageDimensionCohort.getParameters());
    dim.setName("age dimension");

    dim.addCohortDefinition(
        "<5", ageDimensionCohort.createXtoYAgeCohort("Children under 5 years", 0, 4));
    dim.addCohortDefinition("5+", ageDimensionCohort.createXtoYAgeCohort("Over 5 years", 5, 200));
    dim.addCohortDefinition(
        ">60", ageDimensionCohort.createXtoYAgeCohort("Over 60 years", 60, 200));
    return dim;
  }

  /**
   * State of patient, whether new or revisit
   *
   * @return {@link org.openmrs.module.reporting.indicator.dimension.CohortDimension}
   */
  public CohortDefinitionDimension state() {
    CohortDefinitionDimension dim = new CohortDefinitionDimension();
    dim.setName("Patient State");
    dim.addParameter(new Parameter("endDate", "End Date", Date.class));
    dim.addCohortDefinition(
        "NEW",
        EhrReportUtils.map(
            moh717CohortQueries.getPatientStates(EhrReportConstants.OccurenceStates.NEW),
            "onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "RVT",
        EhrReportUtils.map(
            moh717CohortQueries.getPatientStates(EhrReportConstants.OccurenceStates.REVISIT),
            "onOrBefore=${endDate}"));
    return dim;
  }

  /**
   * Patients with encounters on a given date
   *
   * @return @{@link org.openmrs.module.reporting.indicator.dimension.CohortDimension}
   */
  public CohortDefinitionDimension encountersOfMonthPerDay() {
    CohortDefinitionDimension dim = new CohortDefinitionDimension();
    dim.setName("Patient with encounters on date of day");
    dim.addParameter(new Parameter("startDate", "Start Date", Date.class));
    dim.addParameter(new Parameter("endDate", "End Date", Date.class));
    dim.addCohortDefinition(
        "1",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(1),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "2",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(2),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "3",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(3),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "4",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(4),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "5",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(5),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "6",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(6),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "7",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(7),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "8",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(8),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "9",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(9),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "10",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(10),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "11",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(11),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "12",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(12),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "13",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(13),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "14",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(14),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "15",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(15),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "16",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(16),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "17",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(17),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "18",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(18),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "19",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(19),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "20",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(20),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "21",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(21),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "22",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(22),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "23",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(23),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "24",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(24),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "25",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(25),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "26",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(26),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "27",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(27),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "28",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(28),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "29",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(29),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "30",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(30),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));
    dim.addCohortDefinition(
        "31",
        EhrReportUtils.map(
            commonLibrary.getPatientsHavingEncountersOnDate(31),
            "onOrAfter=${startDate},onOrBefore=${endDate}"));

    return dim;
  }
}

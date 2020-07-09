/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.ehrreports.reporting.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.openmrs.GlobalProperty;
import org.openmrs.Program;
import org.openmrs.ProgramWorkflowState;
import org.openmrs.api.context.Context;
import org.openmrs.module.ehrreports.reporting.library.datasets.BaseDataSet;
import org.openmrs.module.reporting.ReportingException;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.evaluation.parameter.Parameterizable;
import org.openmrs.module.reporting.evaluation.parameter.ParameterizableUtil;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.openmrs.module.reporting.report.definition.service.ReportDefinitionService;
import org.openmrs.module.reporting.report.manager.ReportManager;
import org.openmrs.module.reporting.report.manager.ReportManagerUtil;

/** Epts Reports module utilities */
public class EhrReportUtils {

  /**
   * Purges a Report Definition from the database
   *
   * @param reportManager the Report Definition
   */
  public static void purgeReportDefinition(ReportManager reportManager) {
    ReportDefinition findDefinition = findReportDefinition(reportManager.getUuid());
    ReportDefinitionService reportService =
        (ReportDefinitionService) Context.getService(ReportDefinitionService.class);
    if (findDefinition != null) {
      reportService.purgeDefinition(findDefinition);

      // Purge Global property used to track version of report definition
      String gpName = "reporting.reportManager." + reportManager.getUuid() + ".version";
      GlobalProperty gp = Context.getAdministrationService().getGlobalPropertyObject(gpName);
      if (gp != null) {
        Context.getAdministrationService().purgeGlobalProperty(gp);
      }
    }
  }

  /**
   * Returns the Report Definition matching the provided uuid.
   *
   * @param uuid Report Uuid
   * @throws RuntimeException a RuntimeException if the Report Definition can't be found
   * @return Report Definition object
   */
  public static ReportDefinition findReportDefinition(String uuid) {
    ReportDefinitionService reportService =
        (ReportDefinitionService) Context.getService(ReportDefinitionService.class);
    return reportService.getDefinitionByUuid(uuid);
  }

  /**
   * Setup a Report Definition in a database
   *
   * @param reportManager the Report Definition
   */
  public static void setupReportDefinition(ReportManager reportManager) {
    ReportManagerUtil.setupReport(reportManager);
  }

  /**
   * @param parameterizable
   * @param mappings
   * @param <T>
   * @return
   */
  public static <T extends Parameterizable> Mapped<T> map(T parameterizable, String mappings) {
    if (parameterizable == null) {
      throw new IllegalArgumentException("Parameterizable cannot be null");
    }
    String m = mappings != null ? mappings : ""; // probably not necessary, just to be safe
    return new Mapped<T>(parameterizable, ParameterizableUtil.createParameterMappings(m));
  }

  public static String mergeParameterMappings(String... parameters) {
    if (parameters == null || parameters.length == 0) {
      throw new ReportingException("parameters are required");
    }
    LinkedHashSet<String> params = new LinkedHashSet<>();
    for (String p : parameters) {
      params.addAll(new LinkedHashSet<String>(Arrays.asList(p.split(","))));
    }
    return StringUtils.join(params, ",");
  }

  public static String removeMissingParameterMappingsFromCohortDefintion(
      CohortDefinition definition, String mappings) {
    if (definition == null || StringUtils.isEmpty(mappings)) {
      return mappings;
    }
    Iterator<String> mappingsIterator =
        new LinkedHashSet<String>(Arrays.asList(mappings.split(","))).iterator();
    LinkedHashSet<String> existingMappingsSet = new LinkedHashSet<String>();
    while (mappingsIterator.hasNext()) {
      String mapping = mappingsIterator.next();
      for (Parameter p : definition.getParameters()) {
        String paramMap = "${" + p.getName() + "}";
        if (mapping.trim().endsWith(paramMap)) {
          existingMappingsSet.add(mapping);
        }
      }
    }
    return StringUtils.join(existingMappingsSet, ",");
  }

  /**
   * Get the configurable widget parameter to be passed on the reporting UI TODO: redesign this to
   * be more configurable
   *
   * @return
   */
  public static Parameter getProgramConfigurableParameter(Program program) {
    List<ProgramWorkflowState> defaultStates = new ArrayList<>();
    for (ProgramWorkflowState p : program.getAllWorkflows().iterator().next().getStates()) {
      defaultStates.add(p);
    }

    Parameter parameter = new Parameter();
    parameter.setName("state");
    parameter.setLabel("States");
    parameter.setType(ProgramWorkflowState.class);
    parameter.setCollectionType(List.class);
    parameter.setWidgetConfiguration(getProgramProperties(program));
    parameter.setDefaultValue(defaultStates);
    return parameter;
  }

  private static Properties getProgramProperties(Program program) {
    Properties properties = new Properties();
    properties.put("Program", program.getName());
    return properties;
  }

  public static String formatDateWithTime(Date date) {

    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    return formatter.format(date);
  }

  public static String formatDate(Date date) {

    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    return formatter.format(date);
  }

  public static Date getDateFromString(String str) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    return formatter.parse(str);
  }

  public static String getTheDateBasedOnIntegerSupplied(String date, int day) {
    String subStr = date.substring(5);
    // Date input = getDateFromString(date);
    // Calendar calendar = Calendar.getInstance();
    // calendar.setTime(input);
    // calendar.add(Calendar.DATE, day);

    return subStr;
  }

  public static List<BaseDataSet.ColumnParameters> getAdultChildrenColumns() {
    BaseDataSet.ColumnParameters day1 =
        new BaseDataSet.ColumnParameters("day1", "Day 1", "day=1", "01");
    BaseDataSet.ColumnParameters day2 =
        new BaseDataSet.ColumnParameters("day2", "Day 2", "day=2", "02");
    BaseDataSet.ColumnParameters day3 =
        new BaseDataSet.ColumnParameters("day3", "Day 3", "day=3", "03");
    BaseDataSet.ColumnParameters day4 =
        new BaseDataSet.ColumnParameters("day4", "Day 4", "day=4", "04");
    BaseDataSet.ColumnParameters day5 =
        new BaseDataSet.ColumnParameters("day5", "Day 5", "day=5", "05");
    BaseDataSet.ColumnParameters day6 =
        new BaseDataSet.ColumnParameters("day6", "Day 6", "day=6", "06");
    BaseDataSet.ColumnParameters day7 =
        new BaseDataSet.ColumnParameters("day7", "Day 7", "day=7", "07");
    BaseDataSet.ColumnParameters day8 =
        new BaseDataSet.ColumnParameters("day8", "Day 8", "day=8", "08");
    BaseDataSet.ColumnParameters day9 =
        new BaseDataSet.ColumnParameters("day9", "Day 9", "day=9", "09");
    BaseDataSet.ColumnParameters day10 =
        new BaseDataSet.ColumnParameters("day10", "Day 10", "day=10", "10");
    BaseDataSet.ColumnParameters day11 =
        new BaseDataSet.ColumnParameters("day11", "Day 11", "day=11", "11");
    BaseDataSet.ColumnParameters day12 =
        new BaseDataSet.ColumnParameters("day12", "Day 12", "day=12", "12");
    BaseDataSet.ColumnParameters day13 =
        new BaseDataSet.ColumnParameters("day13", "Day 13", "day=13", "13");
    BaseDataSet.ColumnParameters day14 =
        new BaseDataSet.ColumnParameters("day14", "Day 14", "day=14", "14");
    BaseDataSet.ColumnParameters day15 =
        new BaseDataSet.ColumnParameters("day15", "Day 15", "day=15", "15");
    BaseDataSet.ColumnParameters day16 =
        new BaseDataSet.ColumnParameters("day16", "Day 16", "day=16", "16");
    BaseDataSet.ColumnParameters day17 =
        new BaseDataSet.ColumnParameters("day17", "Day 17", "day=17", "17");
    BaseDataSet.ColumnParameters day18 =
        new BaseDataSet.ColumnParameters("day18", "Day 18", "day=18", "18");
    BaseDataSet.ColumnParameters day19 =
        new BaseDataSet.ColumnParameters("day19", "Day 19", "day=19", "19");
    BaseDataSet.ColumnParameters day20 =
        new BaseDataSet.ColumnParameters("day20", "Day 20", "day=20", "20");
    BaseDataSet.ColumnParameters day21 =
        new BaseDataSet.ColumnParameters("day21", "Day 21", "day=21", "21");
    BaseDataSet.ColumnParameters day22 =
        new BaseDataSet.ColumnParameters("day22", "Day 22", "day=22", "22");
    BaseDataSet.ColumnParameters day23 =
        new BaseDataSet.ColumnParameters("day23", "Day 23", "day=23", "23");
    BaseDataSet.ColumnParameters day24 =
        new BaseDataSet.ColumnParameters("day24", "Day 24", "day=24", "24");
    BaseDataSet.ColumnParameters day25 =
        new BaseDataSet.ColumnParameters("day25", "Day 25", "day=25", "25");
    BaseDataSet.ColumnParameters day26 =
        new BaseDataSet.ColumnParameters("day26", "Day 26", "day=26", "26");
    BaseDataSet.ColumnParameters day27 =
        new BaseDataSet.ColumnParameters("day27", "Day 27", "day=27", "27");
    BaseDataSet.ColumnParameters day28 =
        new BaseDataSet.ColumnParameters("day28", "Day 28", "day=28", "28");
    BaseDataSet.ColumnParameters day29 =
        new BaseDataSet.ColumnParameters("day29", "Day 29", "day=29", "29");
    BaseDataSet.ColumnParameters day30 =
        new BaseDataSet.ColumnParameters("day30", "Day 30", "day=30", "30");
    BaseDataSet.ColumnParameters day31 =
        new BaseDataSet.ColumnParameters("day31", "Day 31", "day=31", "31");
    return Arrays.asList(
        day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14,
        day15, day16, day17, day18, day19, day20, day21, day22, day23, day24, day25, day26, day27,
        day28, day29, day30, day31);
  }
}

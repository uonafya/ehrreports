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
package org.openmrs.module.ehrreports.reporting.library.datasets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openmrs.module.reporting.ReportingConstants;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.indicator.CohortIndicator;

public abstract class BaseDataSet {

  /**
   * Adds a row to a dataset based on an indicator and a list of column parameters
   *
   * @param cohortDsd the dataset
   * @param baseName the base columm name
   * @param baseLabel the base column label
   * @param indicator the indicator
   * @param columns the column parameters
   */
  public void addRow(
      CohortIndicatorDataSetDefinition cohortDsd,
      String baseName,
      String baseLabel,
      Mapped<CohortIndicator> indicator,
      List<ColumnParameters> columns) {

    for (ColumnParameters column : columns) {
      String name = baseName + "-" + column.getColumn();
      String label = baseLabel + " (" + column.getLabel() + ")";
      cohortDsd.addColumn(name, label, indicator, column.getDimensions());
    }
  }

  public List<Parameter> getParameters() {
    List<Parameter> parameters = new ArrayList<Parameter>();
    parameters.add(ReportingConstants.START_DATE_PARAMETER);
    parameters.add(ReportingConstants.END_DATE_PARAMETER);
    return parameters;
  }

  public List<ColumnParameters> getAdultChildrenColumns() {
    ColumnParameters day1 = new ColumnParameters("day1", "Day 1", "day=1", "01");
    ColumnParameters day2 = new ColumnParameters("day2", "Day 2", "day=2", "02");
    ColumnParameters day3 = new ColumnParameters("day3", "Day 3", "day=3", "03");
    ColumnParameters day4 = new ColumnParameters("day4", "Day 4", "day=4", "04");
    ColumnParameters day5 = new ColumnParameters("day5", "Day 5", "day=5", "05");
    ColumnParameters day6 = new ColumnParameters("day6", "Day 6", "day=6", "06");
    ColumnParameters day7 = new ColumnParameters("day7", "Day 7", "day=7", "07");
    ColumnParameters day8 = new ColumnParameters("day8", "Day 8", "day=8", "08");
    ColumnParameters day9 = new ColumnParameters("day9", "Day 9", "day=9", "09");
    ColumnParameters day10 = new ColumnParameters("day10", "Day 10", "day=10", "10");
    ColumnParameters day11 = new ColumnParameters("day11", "Day 11", "day=11", "11");
    ColumnParameters day12 = new ColumnParameters("day12", "Day 12", "day=12", "12");
    ColumnParameters day13 = new ColumnParameters("day13", "Day 13", "day=13", "13");
    ColumnParameters day14 = new ColumnParameters("day14", "Day 14", "day=14", "14");
    ColumnParameters day15 = new ColumnParameters("day15", "Day 15", "day=15", "15");
    ColumnParameters day16 = new ColumnParameters("day16", "Day 16", "day=16", "16");
    ColumnParameters day17 = new ColumnParameters("day17", "Day 17", "day=17", "17");
    ColumnParameters day18 = new ColumnParameters("day18", "Day 18", "day=18", "18");
    ColumnParameters day19 = new ColumnParameters("day19", "Day 19", "day=19", "19");
    ColumnParameters day20 = new ColumnParameters("day20", "Day 20", "day=20", "20");
    ColumnParameters day21 = new ColumnParameters("day21", "Day 21", "day=21", "21");
    ColumnParameters day22 = new ColumnParameters("day22", "Day 22", "day=22", "22");
    ColumnParameters day23 = new ColumnParameters("day23", "Day 23", "day=23", "23");
    ColumnParameters day24 = new ColumnParameters("day24", "Day 24", "day=24", "24");
    ColumnParameters day25 = new ColumnParameters("day25", "Day 25", "day=25", "25");
    ColumnParameters day26 = new ColumnParameters("day26", "Day 26", "day=26", "26");
    ColumnParameters day27 = new ColumnParameters("day27", "Day 27", "day=27", "27");
    ColumnParameters day28 = new ColumnParameters("day28", "Day 28", "day=28", "28");
    ColumnParameters day29 = new ColumnParameters("day29", "Day 29", "day=29", "29");
    ColumnParameters day30 = new ColumnParameters("day30", "Day 30", "day=30", "30");
    ColumnParameters day31 = new ColumnParameters("day31", "Day 31", "day=31", "31");
    return Arrays.asList(day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14, day15, day16, day17, day18, day19, day20, day21, day22, day23, day24, day25, day26, day27, day28, day29, day30, day31);
  }

  public static class ColumnParameters {

    private String name;

    private String label;

    private String dimensions;

    private String column;

    /**
     * Default constructor
     *
     * @param name the name
     * @param label the label
     * @param dimensions the dimension parameters
     */
    public ColumnParameters(String name, String label, String dimensions, String column) {
      this.name = name;
      this.label = label;
      this.dimensions = dimensions;
      this.column = column;
    }

    /**
     * Gets the name
     *
     * @return the name
     */
    public String getName() {
      return name;
    }

    /**
     * Gets the label
     *
     * @return the label
     */
    public String getLabel() {
      return label;
    }

    /**
     * Gets the dimension parameters
     *
     * @return the dimension parameters
     */
    public String getDimensions() {
      return dimensions;
    }

    /**
     * Gets the column
     *
     * @return the column
     */
    public String getColumn() {
      return column;
    }
  }
}

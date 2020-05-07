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

import org.openmrs.module.ehrreports.reporting.library.cohorts.GenderCohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.dimension.CohortDefinitionDimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EhrCommonDimension {
	
	@Autowired
	private GenderCohortQueries genderCohortQueries;
	
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
	 * Age range dimension 10-14, 15-19, 20-24, 25-29, 30-34, 35-39, 40-44, 45-49, >=50
	 * 
	 * @return {@link org.openmrs.module.reporting.indicator.dimension.CohortDimension}
	 */
	public CohortDefinitionDimension age(AgeDimensionCohortInterface ageDimensionCohort) {
		CohortDefinitionDimension dim = new CohortDefinitionDimension();
		dim.setParameters(ageDimensionCohort.getParameters());
		dim.setName("age dimension");
		
		dim.addCohortDefinition("UK", ageDimensionCohort.createUnknownAgeCohort());
		dim.addCohortDefinition("<1", ageDimensionCohort.createXtoYAgeCohort("patients with age bellow 1", 0, 0));
		dim.addCohortDefinition("0-4",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 0 and 4 years", 0, 4));
		dim.addCohortDefinition("0-14",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 0 and 14 years", 0, 14));
		dim.addCohortDefinition("0-15",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 0 and 15 years", 0, 15));
		dim.addCohortDefinition("1-4", ageDimensionCohort.createXtoYAgeCohort("patients with age between 1 and 4", 1, 4));
		dim.addCohortDefinition("2-4", ageDimensionCohort.createXtoYAgeCohort("patients with age between 2 and 4", 2, 4));
		dim.addCohortDefinition("5-9", ageDimensionCohort.createXtoYAgeCohort("patients with age between 5 and 9", 5, 9));
		dim.addCohortDefinition("<15", ageDimensionCohort.createXtoYAgeCohort("patients with age below 15", null, 14));
		dim.addCohortDefinition("10-14",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 10 and 14", 10, 14));
		dim.addCohortDefinition("15+", ageDimensionCohort.createXtoYAgeCohort("patients with age over 15", 15, null));
		dim.addCohortDefinition("15-19",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 15 and 19", 15, 19));
		dim.addCohortDefinition("20-24",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 20 and 24", 20, 24));
		dim.addCohortDefinition("25-29",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 25 and 29", 25, 29));
		dim.addCohortDefinition("30-34",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 30 and 34", 30, 34));
		dim.addCohortDefinition("35-39",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 35 and 39", 35, 39));
		dim.addCohortDefinition("40-44",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 40 and 44", 40, 44));
		dim.addCohortDefinition("45-49",
		    ageDimensionCohort.createXtoYAgeCohort("patients with age between 45 and 49", 45, 49));
		dim.addCohortDefinition("50+", ageDimensionCohort.createXtoYAgeCohort("patients with age over 50", 50, null));
		
		dim.addCohortDefinition("20+", ageDimensionCohort.createXtoYAgeCohort("patients with age over 20 years", 20, null));
		
		return dim;
	}
}

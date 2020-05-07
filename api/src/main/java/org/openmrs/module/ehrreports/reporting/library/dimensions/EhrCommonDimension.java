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
import org.openmrs.module.ehrreports.reporting.library.cohorts.Moh717CohortQueries;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportConstants;
import org.openmrs.module.ehrreports.reporting.utils.EhrReportUtils;
import org.openmrs.module.reporting.indicator.dimension.CohortDefinitionDimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EhrCommonDimension {
	
	@Autowired
	private GenderCohortQueries genderCohortQueries;
	
	@Autowired
	private Moh717CohortQueries moh717CohortQueries;
	
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
		
		dim.addCohortDefinition("<5", ageDimensionCohort.createXtoYAgeCohort("Children under 5 years", null, 4));
		dim.addCohortDefinition("5+", ageDimensionCohort.createXtoYAgeCohort("Over 5 years", 5, null));
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
		dim.addCohortDefinition("NEW",
		    EhrReportUtils.map(moh717CohortQueries.getPatientStates(EhrReportConstants.OccurenceStates.NEW), ""));
		dim.addCohortDefinition("RVT",
		    EhrReportUtils.map(moh717CohortQueries.getPatientStates(EhrReportConstants.OccurenceStates.REVISIT), ""));
		return dim;
	}
}

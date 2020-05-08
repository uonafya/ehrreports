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

package org.openmrs.module.ehrreports;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.ehrreports.metadata.ConfigurableMetadataLookupException;
import org.openmrs.module.ehrreports.reporting.EhrReportInitializer;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class EhrReportsActivator extends BaseModuleActivator {

  private Log log = LogFactory.getLog(this.getClass());

  private EhrReportInitializer reportsInitializer = new EhrReportInitializer();

  @Override
  public void contextRefreshed() {
    log.debug("EHR Reports Module refreshed");
  }

  @Override
  public void willRefreshContext() {
    log.debug("Refreshing EHR Reports Module");
  }

  @Override
  public void willStart() {
    log.debug("Starting EHR Reports Module");
  }

  @Override
  public void willStop() {
    log.debug("Stopping EHR Reports Module");
    try {
      reportsInitializer.purgeReports();
      log.debug("EHR Reports purged");
    } catch (Exception e) {
      log.error("An error occured trying to purge EHR reports", e);
    }
  }

  /** @see #started() */
  public void started() {
    AppFrameworkService appFrameworkService = Context.getService(AppFrameworkService.class);
    // disabling the reporting UI app to provide our own custom ones
    appFrameworkService.disableApp("reportingui.reports");
    try {
      reportsInitializer.initializeReports();
      log.info("Started EHR Reports Module");
    } catch (ConfigurableMetadataLookupException e) {
      Context.getAlertService()
          .notifySuperUsers("ehrreports.startuperror.globalproperties", null, e.getMessage());
      throw e;
    } catch (Exception e) {
      Context.getAlertService().notifySuperUsers("ehrreports.startuperror.general", null);
      throw e;
    }
  }

  /** @see #stopped() */
  public void stopped() {
    log.info("Stopped EHR Reports Module");
  }
}

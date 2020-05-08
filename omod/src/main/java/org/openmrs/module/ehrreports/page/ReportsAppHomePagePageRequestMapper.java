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
package org.openmrs.module.ehrreports.page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ui.framework.page.PageRequest;
import org.openmrs.ui.framework.page.PageRequestMapper;
import org.springframework.stereotype.Component;

/**
 * Overrides the mapping from the reports app home page from reporting ui to a new one specified in
 * this module
 */
@Component
public class ReportsAppHomePagePageRequestMapper implements PageRequestMapper {

  protected final Log log = LogFactory.getLog(getClass());

  /**
   * Implementations should call {@link PageRequest#setProviderNameOverride(String)} and {@link
   * PageRequest#setPageNameOverride(String)}, and return true if they want to remap a request, or
   * return false if they didn't remap it.
   *
   * @param request may have its providerNameOverride and pageNameOverride set
   * @return true if this page was mapped (by overriding the provider and/or page), false otherwise
   */
  public boolean mapRequest(PageRequest request) {
    if (request.getProviderName().equals("reportingui")) {
      if (request.getPageName().equals("reportsapp/home")) {
        // change to the custom reports page
        request.setProviderNameOverride("ehrreports");
        request.setPageNameOverride("reports");
        log.info(request.toString());
        return true;
      }
    }
    return false;
  }
}

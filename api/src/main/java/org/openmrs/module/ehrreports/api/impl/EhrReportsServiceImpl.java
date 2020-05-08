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

package org.openmrs.module.ehrreports.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ehrreports.api.EhrReportsService;
import org.openmrs.module.ehrreports.api.dao.EhrReportsDao;

public class EhrReportsServiceImpl extends BaseOpenmrsService implements EhrReportsService {

  private EhrReportsDao dao;

  /** Injected in moduleApplicationContext.xml */
  public void setDao(EhrReportsDao dao) {
    this.dao = dao;
  }

  @Override
  public void purgeReportDesignIfExists(String uuid) {
    String serializedObjectUuid = dao.getSerializedObjectByReportDesignUUID(uuid);
    dao.purgeReportDesign(uuid, serializedObjectUuid);
  }
}

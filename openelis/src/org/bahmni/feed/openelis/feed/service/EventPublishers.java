/*
* The contents of this file are subject to the Mozilla Public License
* Version 1.1 (the "License"); you may not use this file except in
* compliance with the License. You may obtain a copy of the License at
* http://www.mozilla.org/MPL/ 
* 
* Software distributed under the License is distributed on an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
* License for the specific language governing rights and limitations under
* the License.
* 
* The Original Code is OpenELIS code.
* 
* Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
*/

package org.bahmni.feed.openelis.feed.service;

import org.bahmni.feed.openelis.feed.service.impl.OpenElisUrlPublisher;
import org.bahmni.feed.openelis.utils.OpenElisConnectionProvider;
import org.ict4h.atomfeed.server.repository.jdbc.AllEventRecordsJdbcImpl;
import org.ict4h.atomfeed.server.service.EventService;
import org.ict4h.atomfeed.server.service.EventServiceImpl;

public class EventPublishers {
    private final String PATIENT_CATEGORY = "patient";
    private final String RESULT_CATEGORY = "result";
    private final String ACCESSION_CATEGORY = "accession";
    private EventService eventService;

    public EventPublishers() {
        this(new EventServiceImpl(new AllEventRecordsJdbcImpl(new OpenElisConnectionProvider())));
    }

    public EventPublishers(EventService eventService) {
        this.eventService = eventService;
    }

    public OpenElisUrlPublisher patientPublisher() {
        return new OpenElisUrlPublisher(eventService, PATIENT_CATEGORY);
    }

    public OpenElisUrlPublisher testResultPublisher() {
        return new OpenElisUrlPublisher(eventService, RESULT_CATEGORY);
    }

    public OpenElisUrlPublisher accessionPublisher() {
        return new OpenElisUrlPublisher(eventService, ACCESSION_CATEGORY);
    }
}

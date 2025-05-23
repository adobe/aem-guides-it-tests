/*
 * Copyright 2022 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.aem.guides.content.MapContent;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains the utilities to update a dita map in AEM.
 * In this test suite we are using it to add the newly created topic in the map.
 */
public class UpdateDitaMap {

    private static final Logger log = LoggerFactory.getLogger(UpdateDitaMap.class);

    /**
     * This method updates a dita map. In this test suite we are using it to add the newly created topic in the map.
     *
     * @param adminAuthor: {@link CQClient} object
     */
    public void testUpdateDitaMap(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("editorData", MapContent.MAP_CONTENT)
                    .addParameter("operation", "postdita")
                    .addParameter("createrev", "false")
                    .addParameter("path", Constants.TEST_FOLDER_PATH + "/" + Constants.MAP_NAME)
                    .build();
            adminAuthor.doPost("/bin/referencelistener", entity, 200);
        } catch (Exception e) {
            log.error("Error in updating map", e);
            Assert.fail("Error in updating map");
        }
    }
}

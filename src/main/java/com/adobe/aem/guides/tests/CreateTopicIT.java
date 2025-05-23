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
import com.adobe.aem.guides.utils.TemplateType;
import com.adobe.aem.guides.utils.TestUtilities;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains the utilities to create a topic in AEM.
 */
public class CreateTopicIT {

    private static final Logger log = LoggerFactory.getLogger(CreateTopicIT.class);

    /**
     * This method creates a topic in AEM.
     *
     * @param adminAuthor: {@link CQClient} object
     */
    public void testCreateTopic(CQClient adminAuthor) {
        try {
            String template = TestUtilities.getTemplate(adminAuthor, TemplateType.TOPIC_TEMPLATE);
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("template", template)
                    .addParameter("title", "Test Topic")
                    .addParameter("name", Constants.TOPIC_NAME)
                    .addParameter("_charset_", "utf-8")
                    .addParameter("parent", Constants.TEST_FOLDER_PATH)
                    .build();
            adminAuthor.doPost("/bin/fmdita/xmleditor/create", entity, 201);
        } catch (Exception e) {
            log.error("Error in creating topic", e);
            Assert.fail("Error in creating topic");
        }
    }
}

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

import com.adobe.aem.guides.dto.CreateMapRequestDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.aem.guides.utils.TemplateType;
import com.adobe.aem.guides.utils.TestUtilities;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.adobe.aem.guides.Constants.MAP_NAME;
import static com.adobe.aem.guides.Constants.TEST_FOLDER_PATH;

/**
 * This class contains the utilities to create a ditamap in AEM.
 */
public class CreateMapIT {

    private static final Logger log = LoggerFactory.getLogger(CreateMapIT.class);

    /**
     * This method creates a ditamap in AEM.
     *
     * @param adminAuthor
     */
    public void testCreateMap(CQClient adminAuthor) {
        try {
            String template = TestUtilities.getTemplate(adminAuthor, TemplateType.MAP_TEMPLATE);
            CreateMapRequestDto createMapDto = new CreateMapRequestDto()
                    .setName(MAP_NAME)
                    .setTemplate(template)
                    .setTitle("Test Map")
                    .setParent(TEST_FOLDER_PATH);
            StringEntity httpEntity = new StringEntity(JsonUtils.getInstance().getJson(createMapDto));
            httpEntity.setContentType("application/json");
            adminAuthor.doPost("/bin/guides/v1/create/ditamap", httpEntity);
            adminAuthor.doGet(TEST_FOLDER_PATH + "/" + MAP_NAME + ".json", 200);
        } catch (Exception e) {
            log.error("Error in creating ditamap folder", e);
            Assert.fail("Error in creating ditamap");
        }
    }
}

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
import com.adobe.aem.guides.dto.CreateFolderRequestDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains the utilities to create a folder in AEM.
 */
public class CreateFolderIT {

    private static final Logger log = LoggerFactory.getLogger(CreateFolderIT.class);

    /**
     * This method creates a folder in AEM.
     *
     * @param adminAuthor
     */
    public void testCreateFolder(CQClient adminAuthor) {
        try {
            CreateFolderRequestDto createFolderDto = new CreateFolderRequestDto()
                    .setCharset(Constants.UTF_8)
                    .setJcrTitle(Constants.TEST_FOLDER_NAME)
                    .setName(Constants.TEST_FOLDER_NAME)
                    .setPrimaryType("sling:Folder")
                    .setJcrContentPrimaryType("nt:unstructured");
            HttpEntity httpEntity = new StringEntity(JsonUtils.getInstance().getJson(createFolderDto));
            adminAuthor.doPost(Constants.TEST_FOLDER_PATH, httpEntity, 201);
        } catch (Exception e) {
            log.error("Error in creating test folder", e);
            Assert.fail("Error in creating folder");
        }
    }
}

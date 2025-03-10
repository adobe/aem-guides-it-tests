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

package com.adobe.aem.guides.utils;

import com.adobe.aem.guides.dto.GetFolderProfileResponseDto;
import com.adobe.aem.guides.dto.TemplateResponseDto;
import com.adobe.cq.testing.client.CQClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.adobe.aem.guides.Constants.MAP_TEMPLATE_NAME;
import static com.adobe.aem.guides.Constants.TEST_FOLDER_PATH;
import static com.adobe.aem.guides.Constants.TOPIC_TEMPLATE_NAME;

/**
 * Utility class for test methods.
 * This class contains methods to delete folder, get template etc.
 */
public class TestUtils {

    private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static void deleteFolder(CQClient adminAuthor) {
        try {
            SlingHttpResponse slingHttpResponse = adminAuthor.doGet(TEST_FOLDER_PATH + ".json");
            if (slingHttpResponse.getStatusLine().getStatusCode() == 200) {
                UrlEncodedFormEntity entity = FormEntityBuilder.create()
                        .addParameter("cmd", "deletePage")
                        .addParameter("path", TEST_FOLDER_PATH)
                        .addParameter("force", "true")
                        .addParameter("_charset_", "utf-8")
                        .build();
                adminAuthor.doPost("/bin/wcmcommand", entity, 200);
            }
        } catch (Exception e) {
            log.error("Error in deleting test folder", e);
            Assert.fail("Error in deleting folder");
        }
    }

    public static String getTemplate(CQClient adminAuthor, TemplateType templateType) {
        List<TemplateResponseDto> templates = Collections.emptyList();
        String templateToSelect = templateType == TemplateType.MAP_TEMPLATE ? MAP_TEMPLATE_NAME : TOPIC_TEMPLATE_NAME;
        try {
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("operation", "GETFOLDERPROFILEBYID"));
            params.add(new BasicNameValuePair("id", "global-profile"));
            SlingHttpResponse slingHttpResponse = adminAuthor.doGet("/bin/fmdita/folderprofiles", params, 200);
            String content = slingHttpResponse.getContent();
            GetFolderProfileResponseDto responseDto = JsonUtils.getInstance().getObjectFromJsonString(content, GetFolderProfileResponseDto.class);
            if (templateType == TemplateType.MAP_TEMPLATE) {
                templates = responseDto.getMapTemplates();
            } else {
                templates = responseDto.getTemplates();
            }
        } catch (Exception e) {
            log.error("Error in deleting test folder", e);
        }
        Optional<String> template = templates.stream()
                .map(TemplateResponseDto::getPath)
                .filter(path -> FilenameUtils.getName(path).equals(templateToSelect))
                .findFirst();
        return template.orElseThrow(() -> new RuntimeException("Template not found"));
    }
}

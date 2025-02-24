package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.aem.guides.dto.CreateFolderDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFolderIT {

    private static final Logger log = LoggerFactory.getLogger(CreateFolderIT.class);

    public void testCreateFolder(CQClient adminAuthor) {
        try {
            CreateFolderDto createFolderDto = new CreateFolderDto()
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

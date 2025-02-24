package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTopicIT {

    private static final Logger log = LoggerFactory.getLogger(CreateTopicIT.class);

    public void testCreateTopic(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("template", "/content/dam/dita-templates/topics/topic.dita")
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

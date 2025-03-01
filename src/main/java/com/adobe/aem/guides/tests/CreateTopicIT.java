package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.aem.guides.utils.TemplateType;
import com.adobe.aem.guides.utils.TestUtils;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTopicIT {

    private static final Logger log = LoggerFactory.getLogger(CreateTopicIT.class);

    /**
     * This method creates a topic in AEM.
     * @param adminAuthor
     */
    public void testCreateTopic(CQClient adminAuthor) {
        try {
            String template = TestUtils.getTemplate(adminAuthor, TemplateType.TOPIC_TEMPLATE);
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

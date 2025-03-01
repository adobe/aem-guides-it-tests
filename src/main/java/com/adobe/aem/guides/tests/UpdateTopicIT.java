package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.aem.guides.content.TopicContent;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UpdateTopicIT {

    private static final Logger log = LoggerFactory.getLogger(UpdateTopicIT.class);

    /**
     * This method updates a dita topic.
     * In this test suite we are using it to add short description and some descriptive text in a paragraph.
     *
     * @param adminAuthor
     */
    public void testUpdateTopic(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("editorData", TopicContent.TOPIC_CONTENT)
                    .addParameter("operation", "postdita")
                    .addParameter("createrev", "false")
                    .addParameter("path", Constants.TEST_FOLDER_PATH + "/" + Constants.TOPIC_NAME)
                    .build();
            adminAuthor.doPost("/bin/referencelistener", entity, 200);
        } catch (Exception e) {
            log.error("Error in updating topic", e);
            Assert.fail("Error in updating topic");
        }
    }
}

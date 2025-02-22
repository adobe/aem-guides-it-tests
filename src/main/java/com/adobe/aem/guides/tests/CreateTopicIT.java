package com.adobe.aem.guides.tests;

import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;

public class CreateTopicIT {
    public void testCreateTopic(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("template", "/content/dam/dita-templates/topics/topic.dita")
                    .addParameter("title", "Test Topic")
                    .addParameter("name", "test-topic.dita")
                    .addParameter("_charset_", "utf-8")
                    .addParameter("parent", "/content/dam/guides-it-tests")
                    .build();
            adminAuthor.doPost("/bin/fmdita/xmleditor/create", entity, 201);
        } catch (Exception e) {
            Assert.fail("Couldn't read response from System Status endpoint");
        }
    }
}

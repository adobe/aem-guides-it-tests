package com.adobe.aem.guides.tests;

import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateDitaMap {

    private static final Logger log = LoggerFactory.getLogger(UpdateDitaMap.class);
    public void testUpdateDitaMap(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("editorData", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<!DOCTYPE map PUBLIC \"-//OASIS//DTD DITA Map//EN\" \"technicalContent/dtd/map.dtd\">\n" +
                            "<map id=\"GUID-d2612949-42df-4eef-a0ec-7fc81d940b75\">\n" +
                            "  <title>Test Map</title>\n" +
                            "  <topicref href=\"test-topic.dita\" type=\"topic\">\n" +
                            "  </topicref>\n" +
                            "</map>")
                    .addParameter("operation", "postdita")
                    .addParameter("createrev", "false")
                    .addParameter("path", "/content/dam/guides-it-tests/test-map.ditamap")
                    .build();
            adminAuthor.doPost("/bin/referencelistener", entity, 200);
        } catch (Exception e) {
            log.error("Error in updating map", e);
            Assert.fail("Error in updating map");
        }
    }
}

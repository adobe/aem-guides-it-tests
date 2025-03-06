package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.aem.guides.content.MapContent;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains the utilities to update a dita map in AEM.
 * In this test suite we are using it to add the newly created topic in the map.
 */
public class UpdateDitaMap {

    private static final Logger log = LoggerFactory.getLogger(UpdateDitaMap.class);

    /**
     * This method updates a dita map. In this test suite we are using it to add the newly created topic in the map.
     *
     * @param adminAuthor
     */
    public void testUpdateDitaMap(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter("editorData", MapContent.MAP_CONTENT)
                    .addParameter("operation", "postdita")
                    .addParameter("createrev", "false")
                    .addParameter("path", Constants.TEST_FOLDER_PATH + "/" + Constants.MAP_NAME)
                    .build();
            adminAuthor.doPost("/bin/referencelistener", entity, 200);
        } catch (Exception e) {
            log.error("Error in updating map", e);
            Assert.fail("Error in updating map");
        }
    }
}

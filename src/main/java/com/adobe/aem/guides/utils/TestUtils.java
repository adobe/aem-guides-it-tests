package com.adobe.aem.guides.utils;

import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

    private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static boolean deleteFolder(CQClient adminAuthor) {
        try {
            SlingHttpResponse slingHttpResponse = adminAuthor.doGet("/content/dam/guides-it-tests.json");
            if (slingHttpResponse.getStatusLine().getStatusCode() == 200) {
                UrlEncodedFormEntity entity = FormEntityBuilder.create()
                        .addParameter("cmd", "deletePage")
                        .addParameter("path", "/content/dam/guides-it-tests")
                        .addParameter("force", "true")
                        .addParameter("_charset_", "utf-8")
                        .build();
                adminAuthor.doPost("/bin/wcmcommand", entity, 200);
            }
            return true;
        } catch (Exception e) {
            log.error("Error in deleting test folder", e);
            return false;
        }
    }
}

package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.dto.CreateMapDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.aem.guides.utils.TemplateType;
import com.adobe.aem.guides.utils.TestUtils;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.adobe.aem.guides.Constants.MAP_NAME;
import static com.adobe.aem.guides.Constants.TEST_FOLDER_PATH;

public class CreateMapIT {

    private static final Logger log = LoggerFactory.getLogger(CreateMapIT.class);

    /**
     * This method creates a ditamap in AEM.
     * @param adminAuthor
     */
    public void testCreateMap(CQClient adminAuthor) {
        try {
            String template = TestUtils.getTemplate(adminAuthor, TemplateType.MAP_TEMPLATE);
            CreateMapDto createMapDto = new CreateMapDto()
                    .setName(MAP_NAME)
                    .setTemplate(template)
                    .setTitle("Test Map")
                    .setParent(TEST_FOLDER_PATH);
            StringEntity httpEntity = new StringEntity(JsonUtils.getInstance().getJson(createMapDto));
            httpEntity.setContentType("application/json");
            adminAuthor.doPost("/bin/guides/v1/create/ditamap", httpEntity);
            adminAuthor.doGet(TEST_FOLDER_PATH + "/" + MAP_NAME + ".json", 200);
        } catch (Exception e) {
            log.error("Error in creating ditamap folder", e);
            Assert.fail("Error in creating ditamap");
        }
    }
}

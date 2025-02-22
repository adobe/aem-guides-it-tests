package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.dto.CreateMapDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;

public class CreateMapIT {
    public void testCreateMap(CQClient adminAuthor) {
        try {
            CreateMapDto createMapDto = new CreateMapDto()
                    .setName("test-map.ditamap")
                    .setTemplate("/content/dam/dita-templates/maps/map.ditamap")
                    .setTitle("Test Map")
                    .setParent("/content/dam/guides-it-tests");
            StringEntity httpEntity = new StringEntity(JsonUtils.getInstance().getJson(createMapDto));
            httpEntity.setContentType("application/json");
            adminAuthor.doPost("/bin/guides/v1/create/ditamap", httpEntity, 201);
        } catch (Exception e) {
            Assert.fail("Couldn't read response from System Status endpoint");
        }
    }
}

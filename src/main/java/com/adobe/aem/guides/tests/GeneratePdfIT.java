package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.dto.CreateMapDto;
import com.adobe.aem.guides.dto.GenerateOutputDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneratePdfIT {
    private static final Logger log = LoggerFactory.getLogger(GeneratePdfIT.class);

    public void testGeneratePdf(CQClient adminAuthor) {
        try {
            GenerateOutputDto generateOutputDto = new GenerateOutputDto()
                    .setPresetName("test-pdf")
                    .setMapPath("/content/dam/guides-it-tests/test-map.ditamap");
            StringEntity httpEntity = new StringEntity(JsonUtils.getInstance().getJson(generateOutputDto));
            httpEntity.setContentType("application/json");
            adminAuthor.doPost("/bin/guides/v1/output/execute", httpEntity, 200);
        } catch (Exception e) {
            log.info("Couldn't read response from System Status endpoint", e);
            Assert.fail("Couldn't read response from System Status endpoint");
        }
    }
}

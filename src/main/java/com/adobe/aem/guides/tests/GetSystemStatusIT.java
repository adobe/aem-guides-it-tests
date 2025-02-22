package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.dto.SystemStatusResponseDto;
import com.adobe.cq.testing.client.CQClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests if the system status is correct and all the bundles are up and running as expected.
 */
public class GetSystemStatusIT {

    private static final Logger log = LoggerFactory.getLogger(GetSystemStatusIT.class);

    /**
     * Verifies the response of the system status endpoint.
     */
    public void testSystemStatusResponseForCloudTrue(CQClient adminAuthor) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            SlingHttpResponse response = adminAuthor.doGet("/bin/guides/v1/system/status", 200);
            String responseContent = response.getContent();
            log.info("[testSystemStatusResponse] Response from pkgStatus {}", responseContent);

            SystemStatusResponseDto resp = mapper.readValue(responseContent, SystemStatusResponseDto.class);
            Assert.assertTrue(resp.isCloud);
            Assert.assertTrue(resp.isUuid);
            Assert.assertArrayEquals(new String[]{}, resp.inactiveBundles);
        } catch (Exception e) {
            Assert.fail("Couldn't read response from System Status endpoint");
        }
    }
}

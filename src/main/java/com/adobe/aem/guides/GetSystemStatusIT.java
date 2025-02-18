package com.adobe.aem.guides;

import com.adobe.aem.guides.dto.SystemStatusResponseDto;
import com.adobe.cq.testing.client.CQClient;
import com.adobe.cq.testing.junit.rules.CQAuthorPublishClassRule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.testing.clients.ClientException;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSystemStatusIT {

    private static final Logger log = LoggerFactory.getLogger(GetSystemStatusIT.class);

    @ClassRule
    public static final CQAuthorPublishClassRule cqBaseClassRule = new CQAuthorPublishClassRule();

    static CQClient adminAuthor;

    @BeforeClass
    public static void beforeClass() {
        adminAuthor = cqBaseClassRule.authorRule.getAdminClient(CQClient.class);
    }

    @Test
    public void testSystemStatusResponseForCloudTrue() throws ClientException {
        ObjectMapper mapper = new ObjectMapper();
        SlingHttpResponse response = adminAuthor.doGet("/bin/guides/v1/system/status", 200);
        String responseContent = response.getContent();
        log.info("[testSystemStatusResponse] Response from pkgStatus {}", responseContent);

        try {
            SystemStatusResponseDto resp = mapper.readValue(responseContent, SystemStatusResponseDto.class);
            Assert.assertFalse(resp.isCloud);
            Assert.assertTrue(resp.isUuid);
            Assert.assertArrayEquals(new String[]{}, resp.inactiveBundles);
        } catch (Exception e) {
            Assert.fail("Couldn't read response from System Status endpoint. \nError: " + e.getMessage() + "\nContents: " + responseContent);
        }
    }
}

package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.dto.AllPublishingStatusDto;
import com.adobe.aem.guides.dto.GenerateOutputDto;
import com.adobe.aem.guides.dto.PublishingStatusDto;
import com.adobe.aem.guides.utils.JsonUtils;
import com.adobe.cq.testing.client.CQClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.sling.testing.clients.ClientException;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
            log.info("Successfully triggered PDF generation. Will wait for process to complete.");
            PublishingStatusDto publishingStatusDto = checkingPublishingStatus(adminAuthor);
            if (publishingStatusDto != null && !publishingStatusDto.isDitaotFaliure()) {
                log.info("PDF generation completed successfully.");
            } else {
                log.info("PDF generation failed.");
                Assert.fail("PDF generation failed.");
            }
        } catch (Exception e) {
            log.error("Error in generating pdf", e);
            Assert.fail("Error in generating pdf");
        }
    }

    private static PublishingStatusDto checkingPublishingStatus(CQClient adminAuthor) throws ClientException, JsonProcessingException {
        int pollCount = 0;
        int totalPollCount = 50;
        int pollInterval = 10000;
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("source", "/content/dam/guides-it-tests/test-map.ditamap"));
        params.add(new BasicNameValuePair("operation", "PUBLISHBEACON"));
        while (pollCount < totalPollCount) {
            SlingHttpResponse slingHttpResponse = adminAuthor.doGet("/bin/publishlistener", params, 200);
            String content = slingHttpResponse.getContent();
            AllPublishingStatusDto status = JsonUtils.getInstance().getObjectFromJsonString(content, AllPublishingStatusDto.class);
            if (!status.getQueuedOutputs().isEmpty()) {
                log.info("PDF generation is still in progress. Polling again in {} seconds.", pollInterval / 1000);
            } else {
                log.info("PDF generation completed. Poll count: {}", pollCount);
                log.info("log file Path is {}", status.getOutputs().get(0).getDitaotLogFile());
                return status.getOutputs().get(0);
            }
            try {
                Thread.sleep(pollInterval);
            } catch (InterruptedException e) {
                log.error("Error while waiting for PDF generation to complete", e);
                Thread.currentThread().interrupt();
            }
            pollCount++;
        }
        return null;
    }
}

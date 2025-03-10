/*
 * Copyright 2022 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.adobe.aem.guides.tests;

import com.adobe.aem.guides.Constants;
import com.adobe.aem.guides.dto.AllPublishingStatusResponseDto;
import com.adobe.aem.guides.dto.GenerateOutputRequestDto;
import com.adobe.aem.guides.dto.PublishingStatusResponseDto;
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

/**
 * This class contains the utilities to generate a pdf in AEM.
 * It triggers the pdf generation process and checks the status of the process.
 */
public class GeneratePdfIT {
    private static final Logger log = LoggerFactory.getLogger(GeneratePdfIT.class);

    /**
     * This method triggers the pdf generation in AEM.
     *
     * @param adminAuthor: {@link CQClient} object
     */
    public void testGeneratePdf(CQClient adminAuthor) {
        try {
            GenerateOutputRequestDto generateOutputDto = new GenerateOutputRequestDto()
                    .setPresetName("test-pdf")
                    .setMapPath(Constants.TEST_FOLDER_PATH + "/" + Constants.MAP_NAME);
            StringEntity httpEntity = new StringEntity(JsonUtils.getInstance().getJson(generateOutputDto));
            httpEntity.setContentType("application/json");
            adminAuthor.doPost("/bin/guides/v1/output/execute", httpEntity, 200);
            log.info("Successfully triggered PDF generation. Will wait for process to complete.");
            PublishingStatusResponseDto publishingStatusDto = checkingPublishingStatus(adminAuthor);
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

    /**
     * This method checks the status of the pdf generation process.
     * It polls the publish listener servlet to check the status of the pdf generation process.
     *
     * @param adminAuthor: {@link CQClient}
     * @return {@link PublishingStatusResponseDto} containing the publishing status details
     * @throws ClientException in case any exception occurs in API calls
     * @throws JsonProcessingException in case any exception occurs while parsing JSON
     */
    private static PublishingStatusResponseDto checkingPublishingStatus(CQClient adminAuthor) throws ClientException, JsonProcessingException {
        int pollCount = 0;
        int totalPollCount = 50;
        int pollInterval = 5000;
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("source", Constants.TEST_FOLDER_PATH + "/" + Constants.MAP_NAME));
        params.add(new BasicNameValuePair("operation", "PUBLISHBEACON"));
        while (pollCount < totalPollCount) {
            SlingHttpResponse slingHttpResponse = adminAuthor.doGet("/bin/publishlistener", params, 200);
            String content = slingHttpResponse.getContent();
            AllPublishingStatusResponseDto status = JsonUtils.getInstance().getObjectFromJsonString(content, AllPublishingStatusResponseDto.class);
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

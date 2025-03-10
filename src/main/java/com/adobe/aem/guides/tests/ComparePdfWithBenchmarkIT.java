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
import com.adobe.cq.testing.client.CQClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class contains the utilities to compare two PDF file. The PDF files are compared based on the text content.
 */
public class ComparePdfWithBenchmarkIT {

    private static final Logger log = LoggerFactory.getLogger(ComparePdfWithBenchmarkIT.class);

    private static final String RESOURCE_PATH = "/tmp";

    /**
     * This method compares the generated pdf with the benchmark pdf.
     * It downloads the generated pdf from AEM and the benchmark pdf from the storage account.
     * It then compares the text content of both the pdfs.
     *
     * @param adminAuthor: {@link CQClient} object
     */
    public void testComparePdfWithBenchmark(CQClient adminAuthor) {
        downloadGeneratedPdf(adminAuthor);
        downloadBenchmarkPdf();
        comparePdfs();
    }

    /**
     * This method downloads the generated pdf from AEM.
     *
     * @param adminAuthor: {@link CQClient} object
     */
    private void downloadGeneratedPdf(CQClient adminAuthor) {
        try {
            SlingHttpResponse response = adminAuthor.doStreamGet("/content/dam/fmdita-outputs/pdfs/test-map_test-pdf.pdf", null, null, 200);
            HttpEntity entity = response.getEntity();
            Path generatedPdfPath = Paths.get(RESOURCE_PATH, "generated_pdf.pdf");
            log.info("Generated pdf path: {}", generatedPdfPath);
            try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(generatedPdfPath));
                 InputStream stream = entity.getContent()) {
                byte[] buffer = new byte[8 * 1024];
                int read;
                while ((read = stream.read(buffer)) != -1) {
                    bos.write(buffer, 0, read);
                }
            }
            log.info("Generated pdf downloaded successfully");
        } catch (Exception e) {
            log.error("Error in downloading generated pdf", e);
        }
    }

    /**
     * This method downloads the benchmark pdf from the storage account.
     */
    private void downloadBenchmarkPdf() {

        Path destination = Paths.get(RESOURCE_PATH, "benchmark_pdf.pdf"); // Replace with your desired file path

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(Constants.BENCHMARK_PDF_URI);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    try (InputStream inputStream = entity.getContent();
                         FileOutputStream outputStream = new FileOutputStream(destination.toFile())) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        log.info("File downloaded successfully to {}", destination.toAbsolutePath());
                    }
                }
                EntityUtils.consume(entity);
            }
            log.info("benchmark pdf downloaded successfully");
        } catch (Exception e) {
            log.error("Error in downloading benchmark pdf", e);
        }
    }

    /**
     * This method compares the text content of the generated pdf with the benchmark pdf.
     * If the text content of both the pdfs is same, the test passes.
     */
    private void comparePdfs() {
        try {
            String benchmarkPdfPath = Paths.get(RESOURCE_PATH, "benchmark_pdf.pdf").toString();
            String generatedPdfPath = Paths.get(RESOURCE_PATH, "generated_pdf.pdf").toString();
            log.info("benchmark pdf path to compare: {}", benchmarkPdfPath);
            log.info("Generated pdf path to compare: {}", generatedPdfPath);
            String text1 = extractTextFromPDF(benchmarkPdfPath);
            String text2 = extractTextFromPDF(generatedPdfPath);
            if (!text1.equals(text2)) {
                Assert.fail("The PDF files are different.");
            } else {
                log.info("The PDF files are same.");
            }

        } catch (Exception e) {
            log.error("Error in comparing pdfs", e);
            Assert.fail("Error in comparing pdfs");
        }
    }

    private static String extractTextFromPDF(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }
}

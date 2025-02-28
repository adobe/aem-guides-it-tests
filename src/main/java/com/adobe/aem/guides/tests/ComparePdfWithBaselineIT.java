package com.adobe.aem.guides.tests;

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
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparePdfWithBaselineIT {

    private static final Logger log = LoggerFactory.getLogger(ComparePdfWithBaselineIT.class);

    public void testComparePdfWithBaseline(CQClient adminAuthor) {
        downloadGeneratedPdf(adminAuthor);
        downloadBaselinePdf();
        comparePdfs();
    }

    private void downloadGeneratedPdf(CQClient adminAuthor) {
        try {
            SlingHttpResponse response = adminAuthor.doStreamGet("/content/dam/fmdita-outputs/pdfs/test-map_test-pdf.pdf", null, null, 200);
            HttpEntity entity = response.getEntity();
            Path generatedPdfPath = Paths.get(getResourcePath(), "generated_pdf.pdf");
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

    private void downloadBaselinePdf() {
        String fileURL = "https://xmldoxstorage.blob.core.windows.net/xmldoxstorage/aem-guides-store/test-map_test-pdf.pdf?sv=2023-01-03&st=2025-02-28T17%3A16%3A54Z&se=2028-03-01T17%3A16%3A00Z&sr=b&sp=r&sig=aJ4o1KeglPoj%2BrOpfC4QWfN3Lt%2BSXi%2FKjgdPfWABaos%3D"; // Replace with your file URL
        Path destination = Paths.get(getResourcePath(), "baseline_pdf.pdf"); // Replace with your desired file path

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(fileURL);
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
            log.info("Baseline pdf downloaded successfully");
        } catch (Exception e) {
            log.error("Error in downloading baseline pdf", e);
        }
    }

    private void comparePdfs() {
        try {
            String baselinePdfPath = Paths.get(getResourcePath(), "baseline_pdf.pdf").toString();
            String generatedPdfPath = Paths.get(getResourcePath(), "generated_pdf.pdf").toString();
            log.info("baseline pdf path to compare: {}", baselinePdfPath);
            log.info("Generated pdf path to compare: {}", generatedPdfPath);
            String text1 = extractTextFromPDF(baselinePdfPath);
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

    private String getResourcePath() {
        try {
            URL resourceUrl = ComparePdfWithBaselineIT.class.getResource("/");
            return Paths.get(resourceUrl.toURI()).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error in getting resource path", e);
        }
    }

    private static String extractTextFromPDF(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }
}

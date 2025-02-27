package com.adobe.aem.guides.tests;

import com.adobe.cq.testing.client.CQClient;
import org.apache.http.HttpEntity;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.sling.testing.clients.SlingHttpResponse;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComparePdfWithBaselineIT {

    private static final Logger log = LoggerFactory.getLogger(ComparePdfWithBaselineIT.class);

    public void testComparePdfWithBaseline(CQClient adminAuthor) {
        downloadPdf(adminAuthor);
        comparePdfs();
    }

    private void comparePdfs() {
        String filePath1 = Paths.get(getResourcePath(), "test-map_test-pdf.pdf").toString();
        String filePath2 = Paths.get(getResourcePath(), "generated_pdf.pdf").toString();
        try {
            String text1 = extractTextFromPDF(filePath1);
            String text2 = extractTextFromPDF(filePath2);
            if (!text1.equals(text2)) {
                Assert.fail("The PDF files are different.");
            }
        } catch (IOException e) {
            Assert.fail("Error in comparing pdfs");
        }
    }

    private void downloadPdf(CQClient adminAuthor) {
        try {
            SlingHttpResponse response = adminAuthor.doStreamGet("/content/dam/fmdita-outputs/pdfs/test-map_test-pdf.pdf", null, null, 200);
            HttpEntity entity = response.getEntity();
            try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Paths.get(getResourcePath(), "generated_pdf.pdf")));
                 InputStream stream = entity.getContent()) {
                byte[] buffer = new byte[8 * 1024];
                int read;
                while ((read = stream.read(buffer)) != -1) {
                    bos.write(buffer, 0, read);
                }
            }
        } catch (Exception e) {
            log.error("Error in downloading pdf", e);
        }
    }

    private String getResourcePath() {
        URL resourceUrl = ComparePdfWithBaselineIT.class.getResource("/");
        try {
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

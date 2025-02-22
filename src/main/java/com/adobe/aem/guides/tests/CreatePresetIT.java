package com.adobe.aem.guides.tests;

import com.adobe.cq.testing.client.CQClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;

public class CreatePresetIT {
    public void testCreatePreset(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter(":operation", "createoutput")
                    .addParameter("outputTitle", "Test-PDF")
                    .addParameter("outputType", "pdf")
                    .addParameter("sourcePath", "/content/dam/guides-it-tests/test-map.ditamap")
                    .build();
            adminAuthor.doPost("/bin/publishlistener", entity, 200);

            entity = FormEntityBuilder.create()
                    .addParameter(":operation", "saveoutput")
                    .addParameter("outputObj", "{\"outputName\":\"test-pdf\",\"outputType\":\"PDF\",\"outputTitle\":\"test-pdf\",\"ditaValPath\":\"\",\"ditaValPathList\":[],\"ditaValType\":\"none\",\"targetPath\":\"/content/dam/fmdita-outputs/pdfs\",\"fmpsPreset\":{\"name\":\"\",\"id\":\"\"},\"postPublishWorkflow\":\"\",\"performPostPublish\":false,\"cleanTempFiles\":true,\"enableVersioning\":false,\"useBaseline\":false,\"baselineName\":\"\",\"cpName\":\"\",\"customTransName\":\"\",\"lastPublished\":\"\",\"useNamedOutputMetadata\":true,\"siteName\":\"\",\"templatePath\":\"\",\"searchScope\":\"\",\"splitPDFDirectory\":\"/content/dam\",\"generateTOC\":true,\"generateBreadcrumbs\":true,\"overwriteStrategy\":\"ReuseExisting\",\"generateSplitPDF\":false,\"deleteorphanpages\":false,\"passDITAMapMetadata\":false,\"pdfGenerator\":\"ditaot\",\"fileName\":\"${map_filename}_${preset_name}\",\"pdfoptions\":\"High+Quality+Print\",\"pdftagged\":false,\"pdfreviewonly\":false,\"pdfforeachfile\":false,\"pdfnameddestination\":false,\"pdfopenpage\":1,\"pdfregmark\":\"NO_REG_MARKS\",\"pdfpagerange\":\"ALL\",\"pdfstart\":1,\"pdfend\":1,\"pdfzoomlevel\":\"DEFAULT\",\"pdfpagewidth\":8.5,\"pdfpageheight\":11,\"pdfcmyktorgb\":false,\"pdfbookmarks\":false,\"pdfbookmarkleveltype\":\"NONE\",\"pdfbookmarksource\":\"PARAGRAPHS\",\"pdfbookmarkarticles\":\"THREAD_BY_TEXT\",\"pdfbookmarkdisplaytags\":false,\"robosettingsfile\":\"\",\"responsiveGenerator\":\"\",\"epubGenerator\":\"\",\"ditaOtCmdArgs\":\"\",\"metadataList\":[],\"topicType\":\"topic\",\"outputHistoryPath\":\"\",\"presetID\":\"\",\"orphanWithMergedOutput\":false,\"preset-data\":\"\",\"preset-name\":\"\",\"preset-type\":\"\",\"preset-default\":\"\",\"preset-publishType\":\"\",\"retainTempFiles\":false,\"preset-folderProfileID\":\"\"}")
                    .addParameter("cache", "false")
                    .addParameter("sourcePath", "/content/dam/guides-it-tests/test-map.ditamap")
                    .build();
            adminAuthor.doPost("/bin/publishlistener", entity, 200);
        } catch (Exception e) {
            Assert.fail("Couldn't read response from System Status endpoint");
        }

    }
}

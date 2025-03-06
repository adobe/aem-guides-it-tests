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
import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicHeader;
import org.apache.sling.testing.clients.util.FormEntityBuilder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the utilities to create a preset in AEM. A empty preset is created first and then it is being
 * updated with the required values.
 */
public class CreatePresetIT {

    private static final Logger log = LoggerFactory.getLogger(CreatePresetIT.class);

    /**
     * This method creates and then updates a preset in AEM.
     *
     * @param adminAuthor
     */
    public void testCreatePreset(CQClient adminAuthor) {
        try {
            UrlEncodedFormEntity entity = FormEntityBuilder.create()
                    .addParameter(":operation", "createoutput")
                    .addParameter("outputTitle", "test-pdf")
                    .addParameter("outputType", "pdf")
                    .addParameter("sourcePath", Constants.TEST_FOLDER_PATH + "/" + Constants.MAP_NAME)
                    .build();
            adminAuthor.doPost("/bin/publishlistener", entity, 200);
            List<Header> headers = new ArrayList<>();
            headers.add(new BasicHeader("Accept-Encoding", "identity"));
            entity = FormEntityBuilder.create()
                    .addParameter(":operation", "saveoutput")
                    .addParameter("outputObj", "{\"outputName\":\"test-pdf\",\"outputType\":\"PDF\",\"outputTitle\":\"test-pdf\",\"ditaValPath\":\"\",\"ditaValPathList\":[],\"ditaValType\":\"none\",\"targetPath\":\"/content/dam/fmdita-outputs/pdfs\",\"fmpsPreset\":{\"name\":\"\",\"id\":\"\"},\"postPublishWorkflow\":\"\",\"performPostPublish\":false,\"cleanTempFiles\":true,\"enableVersioning\":false,\"useBaseline\":false,\"baselineName\":\"\",\"cpName\":\"\",\"customTransName\":\"\",\"lastPublished\":\"\",\"useNamedOutputMetadata\":true,\"siteName\":\"\",\"templatePath\":\"\",\"searchScope\":\"\",\"splitPDFDirectory\":\"/content/dam\",\"generateTOC\":true,\"generateBreadcrumbs\":true,\"overwriteStrategy\":\"ReuseExisting\",\"generateSplitPDF\":false,\"deleteorphanpages\":false,\"passDITAMapMetadata\":false,\"pdfGenerator\":\"ditaot\",\"fileName\":\"${map_filename}_${preset_name}\",\"pdfoptions\":\"High+Quality+Print\",\"pdftagged\":false,\"pdfreviewonly\":false,\"pdfforeachfile\":false,\"pdfnameddestination\":false,\"pdfopenpage\":1,\"pdfregmark\":\"NO_REG_MARKS\",\"pdfpagerange\":\"ALL\",\"pdfstart\":1,\"pdfend\":1,\"pdfzoomlevel\":\"DEFAULT\",\"pdfpagewidth\":8.5,\"pdfpageheight\":11,\"pdfcmyktorgb\":false,\"pdfbookmarks\":false,\"pdfbookmarkleveltype\":\"NONE\",\"pdfbookmarksource\":\"PARAGRAPHS\",\"pdfbookmarkarticles\":\"THREAD_BY_TEXT\",\"pdfbookmarkdisplaytags\":false,\"robosettingsfile\":\"\",\"responsiveGenerator\":\"\",\"epubGenerator\":\"\",\"ditaOtCmdArgs\":\"\",\"metadataList\":[],\"topicType\":\"topic\",\"outputHistoryPath\":\"\",\"presetID\":\"\",\"orphanWithMergedOutput\":false,\"preset-data\":\"\",\"preset-name\":\"\",\"preset-type\":\"\",\"preset-default\":\"\",\"preset-publishType\":\"\",\"retainTempFiles\":false,\"preset-folderProfileID\":\"\"}")
                    .addParameter("cache", "false")
                    .addParameter("sourcePath", Constants.TEST_FOLDER_PATH + "/" + Constants.MAP_NAME)
                    .build();
            adminAuthor.doPost("/bin/publishlistener", entity, headers, 200);
        } catch (Exception e) {
            log.error("Error in creating preset", e);
            Assert.fail("Error in creating preset");
        }
    }
}

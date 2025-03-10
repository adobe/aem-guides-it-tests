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

package com.adobe.aem.guides;

import com.adobe.aem.guides.tests.ComparePdfWithBenchmarkIT;
import com.adobe.aem.guides.tests.CreateFolderIT;
import com.adobe.aem.guides.tests.CreateMapIT;
import com.adobe.aem.guides.tests.CreatePresetIT;
import com.adobe.aem.guides.tests.CreateTopicIT;
import com.adobe.aem.guides.tests.GeneratePdfIT;
import com.adobe.aem.guides.tests.GetSystemStatusIT;
import com.adobe.aem.guides.tests.UpdateDitaMap;
import com.adobe.aem.guides.tests.UpdateTopicIT;
import com.adobe.aem.guides.utils.TestUtils;
import com.adobe.cq.testing.client.CQClient;
import com.adobe.cq.testing.junit.rules.CQAuthorPublishClassRule;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is the entry point for the Guides User Journey.
 * It runs the tests in the order specified by the {@link FixMethodOrder} annotation.
 * The tests are run in logical order of asset creation, asset modification and then publishing the newly created asset.
 * Finally, the PDF is generated and compared with the baseline pdf to check for any issues in referencing or internal
 * working of AEM Guides.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GuidesUserJourneyIT {

    private static final Logger log = LoggerFactory.getLogger(GuidesUserJourneyIT.class);

    @ClassRule
    public static final CQAuthorPublishClassRule cqBaseClassRule = new CQAuthorPublishClassRule();

    static CQClient adminAuthor;

    @BeforeClass
    public static void beforeClass() {
        adminAuthor = cqBaseClassRule.authorRule.getAdminClient(CQClient.class);
    }

    /**
     * This test method checks the system health before starting the user journey.
     */
    @Test
    public void aaTestCheckSystemHealth() {
        log.info("Checking system health");
        new GetSystemStatusIT().testSystemStatusResponseForCloudTrue(adminAuthor);
    }

    /**
     * This test method deletes the test folder if it exists.
     */
    @Test
    public void abTestDeleteFolder() {
        log.info("Deleting test folder");
        TestUtils.deleteFolder(adminAuthor);
    }

    /**
     * This test method creates a test folder which will be used to create the test dita files.
     */
    @Test
    public void acTestCreateFolder() {
        log.info("Creating test folder");
        new CreateFolderIT().testCreateFolder(adminAuthor);
    }

    /**
     * This test method creates a test topic which will be used as a topicref in the test ditamap.
     */
    @Test
    public void adTestCreateTopic() {
        log.info("Creating test topic");
        new CreateTopicIT().testCreateTopic(adminAuthor);
    }

    /**
     * This test method updates the test topic with some content.
     */
    @Test
    public void aeTestUpdateTopic() {
        log.info("Updating test topic");
        new UpdateTopicIT().testUpdateTopic(adminAuthor);
    }

    /**
     * This test method creates a test map which will be used to generate the PDF.
     */
    @Test
    public void afTestCreateMap() {
        log.info("Creating test map");
        new CreateMapIT().testCreateMap(adminAuthor);
    }

    /**
     * This test method updates the test map with the test topicref.
     */
    @Test
    public void agTestUpdateDitaMap() {
        log.info("Updating test map");
        new UpdateDitaMap().testUpdateDitaMap(adminAuthor);
    }

    /**
     * This test method creates a test preset which will be used to generate the DITA-OT based PDF.
     */
    @Test
    public void ahTestCreatePreset() {
        log.info("Creating test preset");
        new CreatePresetIT().testCreatePreset(adminAuthor);
    }

    /**
     * This test method generates the DITA-OT based PDF using the test map and test preset.
     */
    @Test
    public void aiTestGeneratePdf() {
        log.info("Generating PDF");
        new GeneratePdfIT().testGeneratePdf(adminAuthor);
    }

    /**
     * This test method compares the generated PDF with the benchmark PDF to check for any issues.
     */
    @Test
    public void testJcomparePdfWithBenchmarkPdf() {
        new ComparePdfWithBenchmarkIT().testComparePdfWithBenchmark(adminAuthor);
    }
}

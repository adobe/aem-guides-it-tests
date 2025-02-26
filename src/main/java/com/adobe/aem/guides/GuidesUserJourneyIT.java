package com.adobe.aem.guides;

import com.adobe.aem.guides.tests.ComparePdfWithBaselineIT;
import com.adobe.aem.guides.tests.CreateFolderIT;
import com.adobe.aem.guides.tests.CreateMapIT;
import com.adobe.aem.guides.tests.CreatePresetIT;
import com.adobe.aem.guides.tests.CreateTopicIT;
import com.adobe.aem.guides.tests.GeneratePdfIT;
import com.adobe.aem.guides.tests.GetSystemStatusIT;
import com.adobe.aem.guides.tests.UpdateDitaMap;
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

    @Test
    public void testAcheckSystemHealth() {
        log.info("Checking system health");
        new GetSystemStatusIT().testSystemStatusResponseForCloudTrue(adminAuthor);
    }

    @Test
    public void testBAdeleteFolder() {
        log.info("Deleting test folder");
        TestUtils.deleteFolder(adminAuthor);
    }

    @Test
    public void testBBcreateFolder() {
        log.info("Creating test folder");
        new CreateFolderIT().testCreateFolder(adminAuthor);
    }

    @Test
    public void testCcreateTopic() {
        log.info("Creating test topic");
        new CreateTopicIT().testCreateTopic(adminAuthor);
    }

    @Test
    public void testDcreateMap() {
        log.info("Creating test map");
        new CreateMapIT().testCreateMap(adminAuthor);
    }

    @Test
    public void testEUpdateDitaMap() {
        log.info("Updating test map");
        new UpdateDitaMap().testUpdateDitaMap(adminAuthor);
    }

    @Test
    public void testFcreatePreset() {
        log.info("Creating test preset");
        new CreatePresetIT().testCreatePreset(adminAuthor);
    }

    @Test
    public void testGgeneratePdf() {
        log.info("Generating PDF");
        new GeneratePdfIT().testGeneratePdf(adminAuthor);
    }

    @Test
    public void testHcomparePdfWithBaseline() {
        new ComparePdfWithBaselineIT().testComparePdfWithBaseline(adminAuthor);
    }
}

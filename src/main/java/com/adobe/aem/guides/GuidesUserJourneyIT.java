package com.adobe.aem.guides;

import com.adobe.aem.guides.tests.ComparePdfWithBaselineIT;
import com.adobe.aem.guides.tests.CreateFolderIT;
import com.adobe.aem.guides.tests.CreateMapIT;
import com.adobe.aem.guides.tests.CreatePresetIT;
import com.adobe.aem.guides.tests.CreateTopicIT;
import com.adobe.aem.guides.tests.GeneratePdfIT;
import com.adobe.aem.guides.tests.GetSystemStatusIT;
import com.adobe.cq.testing.client.CQClient;
import com.adobe.cq.testing.junit.rules.CQAuthorPublishClassRule;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void checkSystemHealth() {
        new GetSystemStatusIT().testSystemStatusResponseForCloudTrue(adminAuthor);
    }

    @Test
    public void createFolder() {
        new CreateFolderIT().testCreateFolder(adminAuthor);
    }

    @Test
    public void createTopic() {
        new CreateTopicIT().testCreateTopic(adminAuthor);
    }

    @Test
    public void createMap() {
        new CreateMapIT().testCreateMapAndAddTopic(adminAuthor);
    }

    @Test
    public void createPreset() {
        new CreatePresetIT().testCreatePreset(adminAuthor);
    }

    @Test
    public void generatePdf() {
        new GeneratePdfIT().testGeneratePdf(adminAuthor);
    }

    @Test
    public void comparePdfWithBaseline() {
        new ComparePdfWithBaselineIT().testComparePdfWithBaseline(adminAuthor);
    }
}

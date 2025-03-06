package com.adobe.aem.guides.content;

/**
 * This class contains the content of a test topic. This topic will be injected into a map and then we will publish it.
 */
public class TopicContent {

    private TopicContent() {
    }

    public static final String TOPIC_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE topic PUBLIC \"-//OASIS//DTD DITA Topic//EN\" \"technicalContent/dtd/topic.dtd\">\n" +
            "<topic id=\"topicId\">\n" +
            "  <title>Guides IT Test Topic</title>\n" +
            "  <shortdesc>Topic to test the functionality of AEM Guides</shortdesc>\n" +
            "  <body>\n" +
            "    <p>This topic will be injected into a map and then we will publish it. Once published" +
            " we will validate the generated PDF to see if it matches the baseline pdf already saved in a public store.</p>\n" +
            "  </body>\n" +
            "</topic>";
}

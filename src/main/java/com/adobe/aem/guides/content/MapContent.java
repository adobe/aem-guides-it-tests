package com.adobe.aem.guides.content;

import com.adobe.aem.guides.Constants;

/**
 * This class contains the map content. This map will be used to create a map file in AEM and then we will publish it.
 */
public class MapContent {

    private MapContent() {
    }

    public static final String MAP_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE map PUBLIC \"-//OASIS//DTD DITA Map//EN\" \"technicalContent/dtd/map.dtd\">\n" +
            "<map id=\"GUID-d2612949-42df-4eef-a0ec-7fc81d940b75\">\n" +
            "  <title>Guides IT Test Map</title>\n" +
            "  <topicref href=\"" + Constants.TOPIC_NAME + "\" type=\"topic\">\n" +
            "  </topicref>\n" +
            "</map>";
}

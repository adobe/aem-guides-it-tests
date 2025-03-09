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
            "<map id=\"mapId\">\n" +
            "  <title>Guides IT Test Map</title>\n" +
            "  <topicref href=\"" + Constants.TOPIC_NAME + "\" type=\"topic\">\n" +
            "  </topicref>\n" +
            "</map>";
}

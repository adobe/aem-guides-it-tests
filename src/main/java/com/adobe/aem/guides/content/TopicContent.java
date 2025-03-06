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

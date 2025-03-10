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

/**
 * This class contains the constants used in the project.
 */
public class Constants {

    private Constants() {
    }

    public static final String UTF_8 = "utf-8";
    public static final String TEST_FOLDER_NAME = "guides-upgrade-tests";
    public static final String TEST_FOLDER_PATH = "/content/dam/" + TEST_FOLDER_NAME;
    public static final String MAP_NAME = "test-map.ditamap";
    public static final String TOPIC_NAME = "test.dita";
    public static final String TOPIC_TEMPLATE_NAME = "topic.dita";
    public static final String MAP_TEMPLATE_NAME = "map.ditamap";
    public static final String BENCHMARK_PDF_URI = "https://xmldoxstorage.blob.core.windows.net/xmldoxstorage/aem-guides-store/test-map_test-pdf.pdf?sv=2023-01-03&st=2025-02-28T17%3A16%3A54Z&se=2028-03-01T17%3A16%3A00Z&sr=b&sp=r&sig=aJ4o1KeglPoj%2BrOpfC4QWfN3Lt%2BSXi%2FKjgdPfWABaos%3D";

}

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

package com.adobe.aem.guides.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class contains the request body to create a folder in AEM.
 */
public class CreateFolderRequestDto {
    @JsonProperty("./jcr:content/jcr:title")
    private String JcrTitle;
    @JsonProperty(".name")
    private String name;
    @JsonProperty("./jcr:primaryType")
    private String primaryType;
    @JsonProperty("./jcr:content/jcr:primaryType")
    private String jcrContentPrimaryType;
    @JsonProperty("_charset_")
    private String charset;

    public String getJcrTitle() {
        return JcrTitle;
    }

    public CreateFolderRequestDto setJcrTitle(String jcrTitle) {
        JcrTitle = jcrTitle;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateFolderRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public CreateFolderRequestDto setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
        return this;
    }

    public String getJcrContentPrimaryType() {
        return jcrContentPrimaryType;
    }

    public CreateFolderRequestDto setJcrContentPrimaryType(String jcrContentPrimaryType) {
        this.jcrContentPrimaryType = jcrContentPrimaryType;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public CreateFolderRequestDto setCharset(String charset) {
        this.charset = charset;
        return this;
    }
}

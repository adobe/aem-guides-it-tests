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

/**
 * This class contains the request parameters to create a map in AEM.
 */
public class CreateMapRequestDto {
    private String parent;
    private String title;
    private String name;
    private String template;

    public String getParent() {
        return parent;
    }

    public CreateMapRequestDto setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateMapRequestDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateMapRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public CreateMapRequestDto setTemplate(String template) {
        this.template = template;
        return this;
    }
}

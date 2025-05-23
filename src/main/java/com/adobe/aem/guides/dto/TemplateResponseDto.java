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
 * This class contains the template details like path and id.
 */
public class TemplateResponseDto {
    private String path;
    private String id;

    public String getPath() {
        return path;
    }

    public TemplateResponseDto setPath(String path) {
        this.path = path;
        return this;
    }

    public String getId() {
        return id;
    }

    public TemplateResponseDto setId(String id) {
        this.id = id;
        return this;
    }
}

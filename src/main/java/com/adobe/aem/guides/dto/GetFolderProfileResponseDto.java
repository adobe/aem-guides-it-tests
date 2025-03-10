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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class contains the response DTO for the get folder profile API.
 * For this test utilities we are only de-serializing the template details from the folder profile
 * and ignoring other details.
 * Each template is represented using the {@link TemplateResponseDto} class.
 */
public class GetFolderProfileResponseDto {

    @JsonProperty("map_templates")
    private List<TemplateResponseDto> mapTemplates;
    private List<TemplateResponseDto> templates;

    public List<TemplateResponseDto> getMapTemplates() {
        return mapTemplates;
    }

    public GetFolderProfileResponseDto setMapTemplates(List<TemplateResponseDto> mapTemplates) {
        this.mapTemplates = mapTemplates;
        return this;
    }

    public List<TemplateResponseDto> getTemplates() {
        return templates;
    }

    public GetFolderProfileResponseDto setTemplates(List<TemplateResponseDto> templates) {
        this.templates = templates;
        return this;
    }
}

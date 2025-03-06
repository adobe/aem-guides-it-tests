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

public class GetFolderProfileResponseDto {

    @JsonProperty("map_templates")
    private List<Template> mapTemplates;
    private List<Template> templates;

    public List<Template> getMapTemplates() {
        return mapTemplates;
    }

    public GetFolderProfileResponseDto setMapTemplates(List<Template> mapTemplates) {
        this.mapTemplates = mapTemplates;
        return this;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public GetFolderProfileResponseDto setTemplates(List<Template> templates) {
        this.templates = templates;
        return this;
    }
}

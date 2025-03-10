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
 * DTO class to hold the request parameters for generating output.
 */
public class GenerateOutputRequestDto {
    private String presetName;
    private String mapPath;
    private String nodejs;

    public String getPresetName() {
        return presetName;
    }

    public GenerateOutputRequestDto setPresetName(String presetName) {
        this.presetName = presetName;
        return this;
    }

    public String getMapPath() {
        return mapPath;
    }

    public GenerateOutputRequestDto setMapPath(String mapPath) {
        this.mapPath = mapPath;
        return this;
    }

    public String getNodejs() {
        return nodejs;
    }

    public GenerateOutputRequestDto setNodejs(String nodejs) {
        this.nodejs = nodejs;
        return this;
    }
}

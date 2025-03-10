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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the response DTO for the system status API.
 * This DTO contains the list of active and inactive bundles and also if the build is cloud or uuid build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStatusResponseDto {
    private String[] activeBundles;
    private String[] inactiveBundles;

    @JsonProperty("isCloud")
    private boolean cloud;
    @JsonProperty("isUuid")
    private boolean uuid;

    public String[] getActiveBundles() {
        return activeBundles;
    }

    public SystemStatusResponseDto setActiveBundles(String[] activeBundles) {
        this.activeBundles = activeBundles;
        return this;
    }

    public String[] getInactiveBundles() {
        return inactiveBundles;
    }

    public SystemStatusResponseDto setInactiveBundles(String[] inactiveBundles) {
        this.inactiveBundles = inactiveBundles;
        return this;
    }

    public boolean isCloud() {
        return cloud;
    }

    public SystemStatusResponseDto setCloud(boolean cloud) {
        this.cloud = cloud;
        return this;
    }

    public boolean isUuid() {
        return uuid;
    }

    public SystemStatusResponseDto setUuid(boolean uuid) {
        this.uuid = uuid;
        return this;
    }
}


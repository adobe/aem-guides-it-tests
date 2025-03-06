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

@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStatusResponseDto {
    private String[] activeBundles;
    private String[] inactiveBundles;
    private Boolean isCloud;
    private Boolean isUuid;

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

    public Boolean getCloud() {
        return isCloud;
    }

    public SystemStatusResponseDto setCloud(Boolean cloud) {
        isCloud = cloud;
        return this;
    }

    public Boolean getUuid() {
        return isUuid;
    }

    public SystemStatusResponseDto setUuid(Boolean uuid) {
        isUuid = uuid;
        return this;
    }
}


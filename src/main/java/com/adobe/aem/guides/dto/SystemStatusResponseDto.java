package com.adobe.aem.guides.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStatusResponseDto {
    public String[] activeBundles;
    public String[] inactiveBundles;
    public Boolean isCloud;
    public Boolean isUuid;
}


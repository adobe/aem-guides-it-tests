package com.adobe.aem.guides.dto;

import org.codehaus.jackson.annotate.JsonProperty;

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

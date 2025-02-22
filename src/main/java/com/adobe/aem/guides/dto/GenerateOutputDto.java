package com.adobe.aem.guides.dto;

public class GenerateOutputDto {
    private String presetName;
    private String mapPath;
    private String nodejs;

    public String getPresetName() {
        return presetName;
    }

    public GenerateOutputDto setPresetName(String presetName) {
        this.presetName = presetName;
        return this;
    }

    public String getMapPath() {
        return mapPath;
    }

    public GenerateOutputDto setMapPath(String mapPath) {
        this.mapPath = mapPath;
        return this;
    }

    public String getNodejs() {
        return nodejs;
    }

    public GenerateOutputDto setNodejs(String nodejs) {
        this.nodejs = nodejs;
        return this;
    }
}

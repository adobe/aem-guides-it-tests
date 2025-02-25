package com.adobe.aem.guides.dto;

public class Template {
    private String path;
    private String id;

    public String getPath() {
        return path;
    }

    public Template setPath(String path) {
        this.path = path;
        return this;
    }

    public String getId() {
        return id;
    }

    public Template setId(String id) {
        this.id = id;
        return this;
    }
}

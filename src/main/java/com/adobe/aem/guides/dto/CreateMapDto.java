package com.adobe.aem.guides.dto;

public class CreateMapDto {
    private String parent;
    private String title;
    private String name;
    private String template;

    public String getParent() {
        return parent;
    }

    public CreateMapDto setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateMapDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateMapDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public CreateMapDto setTemplate(String template) {
        this.template = template;
        return this;
    }
}

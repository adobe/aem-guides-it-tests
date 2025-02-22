package com.adobe.aem.guides.dto;

public class CreateTopicDto {
    private String parent;
    private String title;
    private String name;
    private String template;

    public String getParent() {
        return parent;
    }

    public CreateTopicDto setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateTopicDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateTopicDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public CreateTopicDto setTemplate(String template) {
        this.template = template;
        return this;
    }
}

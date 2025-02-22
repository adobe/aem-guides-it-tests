package com.adobe.aem.guides.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateFolderDto {
    @JsonProperty("./jcr:content/jcr:title")
    private String JcrTitle;
    @JsonProperty(".name")
    private String name;
    @JsonProperty("./jcr:primaryType")
    private String primaryType;
    @JsonProperty("./jcr:content/jcr:primaryType")
    private String jcrContentPrimaryType;
    @JsonProperty("_charset_")
    private String charset;

    public String getJcrTitle() {
        return JcrTitle;
    }

    public CreateFolderDto setJcrTitle(String jcrTitle) {
        JcrTitle = jcrTitle;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateFolderDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public CreateFolderDto setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
        return this;
    }

    public String getJcrContentPrimaryType() {
        return jcrContentPrimaryType;
    }

    public CreateFolderDto setJcrContentPrimaryType(String jcrContentPrimaryType) {
        this.jcrContentPrimaryType = jcrContentPrimaryType;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public CreateFolderDto setCharset(String charset) {
        this.charset = charset;
        return this;
    }
}

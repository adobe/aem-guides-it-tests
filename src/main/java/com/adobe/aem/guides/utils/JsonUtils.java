package com.adobe.aem.guides.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JsonUtils {

    private ObjectMapper mapper;
    private static JsonUtils instance;

    public static JsonUtils getInstance() {
        if (instance == null) {
            instance = new JsonUtils();
        }
        return instance;
    }

    private JsonUtils() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public String getJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error in json processing", e);
        }
    }

    public <T> T getObjectFromJson(JsonNode jsonNode, Class<T> valueType) throws JsonProcessingException {
        return mapper.treeToValue(jsonNode, valueType);
    }

    public <T> T getObjectFromJsonString(String json, Class<T> valueType) throws JsonProcessingException {
        return mapper.readValue(json, valueType);
    }

    public <T> T getObjectFromJsonString(String json, TypeReference<T> valueType) throws JsonProcessingException {
        return mapper.readValue(json, valueType);
    }

    public <T> T getObjectFromFileStream(InputStream inputStream, Class<T> valueType) throws IOException {
        return mapper.readValue(inputStream, valueType);
    }

    public <T> T convert(Map<String, Object> map, Class<T> valueType) {
        return mapper.convertValue(map, valueType);
    }
}

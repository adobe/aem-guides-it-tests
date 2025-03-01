package com.adobe.aem.guides.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Utility class for JSON operations
 * This class uses Jackson library for JSON operations
 * Jackson is a high-performance JSON processor for Java
 * It is used to serialize and deserialize Java objects to (and from) JSON
 * It has a very powerful data binding mechanism that provides a rich set of features for mapping Java objects to JSON and back
 * It is a widely used library in the Java community
 * It is used in many popular Java frameworks like Spring, Jersey, JAX-RS, Resteasy, and many others
 */
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

    public <T> T getObjectFromJsonString(String json, Class<T> valueType) throws JsonProcessingException {
        return mapper.readValue(json, valueType);
    }
}

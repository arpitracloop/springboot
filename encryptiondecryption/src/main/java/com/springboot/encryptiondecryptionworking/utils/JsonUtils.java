package com.springboot.encryptiondecryptionworking.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    public static String serializeAsJson(Object inputObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(inputObject);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> T deserializeFromJson(String content, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(content, valueType);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public static <T> T deserializeByteFromJson(byte[] content, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(content, valueType);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public static byte[] serializeAsJsonBytes(Object inputObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(inputObject).getBytes();
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <K, V> Map<K, V> deserializeMapFromJson(String content, Class<? extends Map> mapClass,
                                                          Class<K> keyClass, Class<V> valueClass) {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(mapClass, keyClass, valueClass);
        try {
            return mapper.readValue(content, mapType);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}

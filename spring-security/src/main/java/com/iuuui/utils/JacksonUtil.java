package com.iuuui.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author iuuui
 * @date 2025/03/30 0138
 */
public abstract class JacksonUtil {

    final static ObjectMapper objectMapper = new ObjectMapper();


    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return objectMapper.convertValue(fromValue, toValueType);
    }

    public static <T> T readValue(Object fromValue, Class<T> toValueType) {
        try {
            return objectMapper.readValue((JsonParser) fromValue, toValueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeValueAsString(Object val) {
        try {
            return objectMapper.writeValueAsString(val);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

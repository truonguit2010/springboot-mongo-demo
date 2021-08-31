package com.realbizgames.demo.mongo.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ServiceJsonMapper {

    ObjectMapper mapper;

    public ServiceJsonMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateSerializer.INSTANCE);
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)//
                .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)//
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)//
                .registerModule(module);
    }

    public <T> T convertJsonObject(JSONObject jsonObject, Class<T> genericType) throws JsonProcessingException {
        String jsonString = mapper.writeValueAsString(jsonObject);
        return (T) mapper.readValue(jsonString, genericType);
    }

}

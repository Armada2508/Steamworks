package org.usfirst.frc.team2508.robot.util;

import java.io.IOException;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.mashape.unirest.http.ObjectMapper;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;

public class VisionService {
    public VisionService() {
//        Unirest.setObjectMapper(new ObjectMapper() {
//            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
//
//            public <T> T readValue(String value, Class<T> valueType) {
//                try {
//                    return jacksonObjectMapper.readValue(value, valueType);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            public String writeValue(Object value) {
//                try {
//                    return jacksonObjectMapper.writeValueAsString(value);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
    }

    public Location retrieveLocation() {
//        try {
//            return Unirest.get("http://10.25.8.28:5800/location").asObject(Location.class).getBody();
//        } catch (UnirestException ue) {
//            ue.printStackTrace();
//            return null;
//        }
    	//TODO: This was just added to make things compile
    	return null;
    }
}

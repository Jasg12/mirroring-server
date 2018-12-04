package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorValue;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class SensorValueReadingConverter implements Converter<String, SensorValue> {

    @Override
    public SensorValue convert(String sensorValue) {
        try{
            ObjectMapper om = new ObjectMapper();
            JsonNode valueJson = om.readTree(sensorValue);
            String className = valueJson.get("classs").asText();
            className = convertClassName(className);
            Class classs = Class.forName(className);
            SensorValue value = (SensorValue)om.readValue(sensorValue, classs);

            return value;
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }

    private String convertClassName(String className){
        switch (className){
            case "com.sjsu.cmpe.sstreet.webserver.model.cassandra.TemperatureSensorValue":
                return "com.sjsu.cmpe.sstreet.mirroringserver.model.TemperatureSensorValue";
            case "com.sjsu.cmpe.sstreet.webserver.model.cassandra.WindSpeedSensorValue":
                return "com.sjsu.cmpe.sstreet.mirroringserver.model.WindSpeedSensorValue";
            case "com.sjsu.cmpe.sstreet.webserver.model.cassandra.WindDirectionSensorValue":
                return "com.sjsu.cmpe.sstreet.mirroringserver.model.WindDirectionSensorValue";
                default:
                    return className;
        }
    }
}

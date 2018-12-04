package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorValue;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class SensorValueWritingConverter implements Converter<SensorValue, String> {

    @Override
    public String convert(SensorValue SensorValue) {

        try{
            ObjectMapper om = new ObjectMapper();
            return om.writeValueAsString(SensorValue);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }
}

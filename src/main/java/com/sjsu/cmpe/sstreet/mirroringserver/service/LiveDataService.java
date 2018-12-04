package com.sjsu.cmpe.sstreet.mirroringserver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sjsu.cmpe.sstreet.mirroringserver.model.*;
import com.sjsu.cmpe.sstreet.mirroringserver.model.statistic.ConnectivityStat;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class LiveDataService {

    private final String CLUSTER_CONNECTIVITY_API = "/cluster/status";
    private final String GET_SENSOR_DATA_API = "/sensor/get/sensorData";

    private RestTemplate restTemplate;
    private Logger log;
    private SensorDataService sensorDataService;
    private SensorService sensorService;

    @Value(value = "${cluster.device.url}")
    private String clusterURL;

    @Autowired
    public LiveDataService(
        RestTemplate restTemplate,
        Logger log,
        SensorDataService sensorDataService,
        SensorService sensorService)
    {
        this.restTemplate = restTemplate;
        this.log = log;
        this.sensorDataService = sensorDataService;
        this.sensorService = sensorService;
    }

    public ConnectivityStat getClusterConnectivityStatistic(){
        String url = clusterURL + CLUSTER_CONNECTIVITY_API;
        ConnectivityStat connectivityStat = restTemplate.getForObject(url, ConnectivityStat.class);

        return connectivityStat;
    }

    public void pullSensorData(Sensor sensor){
        String url = clusterURL + GET_SENSOR_DATA_API;
        HttpEntity<Sensor> httpEntity = new HttpEntity<>(sensor);
        JsonNode sensorDataJson = restTemplate.postForObject(url, httpEntity, JsonNode.class);
        SensorData sensorData = constructSensorData(sensorDataJson);
        sensorDataService.save(sensorData);
        sensor.setLastDataCollectingTimestamp(new Date());
        sensorService.updateSensor(sensor);

        log.debug("Getting Sensor Data from simulator");

    }

    private SensorData constructSensorData(JsonNode sensorData){
        Integer idSmartCluster = sensorData.get("idSmartCluster").asInt();
        Integer idSmartNode = sensorData.get("idSmartNode").asInt();
        Integer idSensor = sensorData.get("idSensor").asInt();
        SensorType type = SensorType.valueOf(sensorData.get("type").asText());
        Long timestamp = sensorData.get("timestamp").asLong();
        JsonNode value = sensorData.get("value");
        SensorValue valueBean = null;
        switch (type){
            case TEMPERATURE:
                 Integer temperature = value.get("temperature").asInt();
                 TemperatureType temperatureType =  TemperatureType.valueOf(value.get("dataType").asText());
                valueBean = new TemperatureSensorValue(temperature, temperatureType);
                break;
            case WIND_SPEED:
                 Integer speed = value.get("speed").asInt();
                 SpeedType speedType = SpeedType.valueOf(value.get("dataType").asText());
                valueBean = new WindSpeedSensorValue(speed, speedType);
                break;
            case WIND_DIRECTION:
                WindDirectionType direction = WindDirectionType.valueOf(value.get("direction").asText());
                valueBean = new WindDirectionSensorValue(direction);
        }

        SensorData result = new SensorData(idSmartCluster, idSmartNode, type, timestamp, idSensor, valueBean);

        return result;
    }
}

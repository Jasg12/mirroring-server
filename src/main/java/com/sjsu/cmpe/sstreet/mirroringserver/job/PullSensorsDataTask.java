package com.sjsu.cmpe.sstreet.mirroringserver.job;

import com.sjsu.cmpe.sstreet.mirroringserver.model.Sensor;
import com.sjsu.cmpe.sstreet.mirroringserver.service.LiveDataService;
import com.sjsu.cmpe.sstreet.mirroringserver.service.SensorService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PullSensorsDataTask {

    private Logger log;
    private SensorService sensorService;
    private LiveDataService liveDataService;

    @Value(value = "${cluster.serial.number}")
    private String clusterSerialNumber;

    @Autowired
    public PullSensorsDataTask(
        Logger log,
        SensorService sensorService,
        LiveDataService liveDataService)
    {

        this.log = log;
        this.sensorService = sensorService;
        this.liveDataService = liveDataService;
    }

    @Scheduled(fixedRate = 8000)
    public void pullSensorsData(){
        List<Sensor> sensors = sensorService.getSensorsByClusterSerialNumber(clusterSerialNumber);
        for (Sensor sensor:sensors){
            Long currentTime = new Date().getTime();
            Date lastTimeCollected = sensor.getLastDataCollectingTimestamp();
            Long lastTimeCollectedTime = lastTimeCollected != null?lastTimeCollected.getTime():0l;
            if((lastTimeCollectedTime + sensor.getDataCollectingInterval()) < currentTime){
                liveDataService.pullSensorData(sensor);
            } else {
                log.debug("The sensor data already collected for this time range sensorId:{} last time collected:{}", sensor.getIdSensor(), sensor.getLastDataCollectingTimestamp());
            }
        }

        log.info("Sensors size:{}", sensors.size());
    }

}

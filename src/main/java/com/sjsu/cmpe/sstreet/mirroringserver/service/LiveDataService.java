package com.sjsu.cmpe.sstreet.mirroringserver.service;

import com.sjsu.cmpe.sstreet.mirroringserver.model.statistic.ConnectivityStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LiveDataService {

    private final String CLUSTER_CONNECTIVITY_API = "/cluster/connectivity";

    private RestTemplate restTemplate;

    @Value(value = "cluster.device.url")
    private String clusterURL;

    @Autowired
    public LiveDataService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public ConnectivityStat getClusterConnectivityStatistic(){
        String url = clusterURL + CLUSTER_CONNECTIVITY_API;
        ConnectivityStat connectivityStat = restTemplate.getForObject(url, ConnectivityStat.class);

        return connectivityStat;
    }

}

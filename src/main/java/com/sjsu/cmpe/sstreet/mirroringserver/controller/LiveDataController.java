package com.sjsu.cmpe.sstreet.mirroringserver.controller;

import com.sjsu.cmpe.sstreet.mirroringserver.model.statistic.ConnectivityStat;
import com.sjsu.cmpe.sstreet.mirroringserver.service.LiveDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LiveDataController {

    private LiveDataService liveDataService;

    @Autowired
    public LiveDataController(LiveDataService liveDataService) {

        this.liveDataService = liveDataService;
    }

    @RequestMapping(value = "/cluster/connectivity/statistic/", method = RequestMethod.GET, produces = "application/json")
    public ConnectivityStat getClusterConnectivityStatistic(){
        return liveDataService.getClusterConnectivityStatistic();
    }

}

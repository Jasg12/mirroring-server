package com.sjsu.cmpe.sstreet.mirroringserver.controller;

import com.sjsu.cmpe.sstreet.mirroringserver.model.Location;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.service.SmartClusterService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smart_cluster")
public class SmartClusterController {

    private final SmartClusterService smartClusterService;
    private Logger log;

    @Autowired
    public SmartClusterController(SmartClusterService smartClusterService, Logger log) {

        this.smartClusterService = smartClusterService;
        this.log = log;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = "application/json")
    public SmartCluster createSmartCluster(@RequestBody SmartCluster smartCluster){

        log.info("Getting request to create cluster:{}", smartCluster);
        return smartClusterService.createSmartCluster(smartCluster);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "application/json")
    public SmartCluster updateSmartCluster(@RequestBody SmartCluster smartCluster){

        return smartClusterService.updateSmartCluster(smartCluster);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public @ResponseBody List<SmartCluster> getAllSmartCluster(){

        return smartClusterService.getAllSmartClusters();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byId/{idSmartCluster}")
    public @ResponseBody SmartCluster getSmartClusterById(@PathVariable(value = "idSmartCluster") Integer idSmartCluster){

        return smartClusterService.getSmartClusterById(idSmartCluster);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byLocation")
    public @ResponseBody SmartCluster getSmartClusterByLocation(@RequestBody Location location){

        return smartClusterService.getSmartClusterByLocation(location);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byName/{name}")
    public @ResponseBody SmartCluster getSmartClusterByName(@PathVariable(value = "name") String name){

        return smartClusterService.getSmartClusterByName(name);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byName/{name}")
    public @ResponseBody ResponseEntity<String> deleteSmartClusterByName(@PathVariable(value = "name") String name){

        return smartClusterService.deleteSmartClusterByName(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byId/{id}")
    public @ResponseBody ResponseEntity<String> deleteSmartClusterById(@PathVariable(value = "id") Integer idSmartCluster){

        return smartClusterService.deleteSmartClusterById(idSmartCluster);
    }


}

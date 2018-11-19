package com.sjsu.cmpe.sstreet.mirroringserver.controller;

import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.LocationDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterUpdateDto;
import com.sjsu.cmpe.sstreet.mirroringserver.service.SmartClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smart_cluster")
public class SmartClusterController {

    private final SmartClusterService smartClusterService;

    @Autowired
    public SmartClusterController(SmartClusterService smartClusterService) {
        this.smartClusterService = smartClusterService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public @ResponseBody ResponseEntity<String> createSmartCluster(@RequestBody SmartClusterDto smartClusterDto){

        return smartClusterService.createSmartCluster(smartClusterDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody ResponseEntity<String> updateSmartCluster(@RequestBody SmartClusterUpdateDto smartClusterUpdateDto){

        return smartClusterService.updateSmartCluster(smartClusterUpdateDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public @ResponseBody List<SmartClusterDto> getAllSmartCluster(){

        return smartClusterService.getAllSmartClusters();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byId/{idSmartCluster}")
    public @ResponseBody SmartClusterDto getSmartClusterById(@PathVariable(value = "idSmartCluster") Integer idSmartCluster){

        return smartClusterService.getSmartClusterById(idSmartCluster);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byLocation")
    public @ResponseBody SmartClusterDto getSmartClusterByLocation(@RequestBody LocationDto locationDto){

        return smartClusterService.getSmartClusterByLocation(locationDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byName/{name}")
    public @ResponseBody SmartClusterDto getSmartClusterByName(@PathVariable(value = "name") String name){

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

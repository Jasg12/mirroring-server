package com.sjsu.cmpe.sstreet.mirroringserver.controller.infrastructure_manager;

import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.LocationDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterUpdateDto;
import com.sjsu.cmpe.sstreet.mirroringserver.service.infrastructure_manager.SmartClusterIMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smart_cluster")
public class SmartClusterIMController {

    private final SmartClusterIMService smartClusterIMService;

    @Autowired
    public SmartClusterIMController(SmartClusterIMService smartClusterIMService) {
        this.smartClusterIMService = smartClusterIMService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public @ResponseBody ResponseEntity<String> createSmartCluster(@RequestBody SmartClusterDto smartClusterDto){

        return smartClusterIMService.createSmartCluster(smartClusterDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody ResponseEntity<String> updateSmartCluster(@RequestBody SmartClusterUpdateDto smartClusterUpdateDto){

        return smartClusterIMService.updateSmartCluster(smartClusterUpdateDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public @ResponseBody List<SmartClusterDto> getAllSmartCluster(){

        return smartClusterIMService.getAllSmartClusters();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byId/{idSmartCluster}")
    public @ResponseBody SmartClusterDto getSmartClusterById(@PathVariable(value = "idSmartCluster") Integer idSmartCluster){

        return smartClusterIMService.getSmartClusterById(idSmartCluster);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byLocation")
    public @ResponseBody SmartClusterDto getSmartClusterByLocation(@RequestBody LocationDto locationDto){

        return smartClusterIMService.getSmartClusterByLocation(locationDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byName/{name}")
    public @ResponseBody SmartClusterDto getSmartClusterByName(@PathVariable(value = "name") String name){

        return smartClusterIMService.getSmartClusterByName(name);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byName/{name}")
    public @ResponseBody ResponseEntity<String> deleteSmartClusterByName(@PathVariable(value = "name") String name){

        return smartClusterIMService.deleteSmartClusterByName(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byId/{id}")
    public @ResponseBody ResponseEntity<String> deleteSmartClusterById(@PathVariable(value = "id") Integer idSmartCluster){

        return smartClusterIMService.deleteSmartClusterById(idSmartCluster);
    }


}

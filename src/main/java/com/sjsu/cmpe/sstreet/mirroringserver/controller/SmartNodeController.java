package com.sjsu.cmpe.sstreet.mirroringserver.controller;

import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.LocationDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartNodeDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartNodeUpdateDto;

import com.sjsu.cmpe.sstreet.mirroringserver.service.SmartNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smart_node")
public class SmartNodeController {

    private final SmartNodeService smartNodeService;

    @Autowired
    public SmartNodeController(SmartNodeService smartNodeService) {
        this.smartNodeService = smartNodeService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public @ResponseBody ResponseEntity<String> createSmartNode(@RequestBody SmartNodeDto smartNodeDto){

        return smartNodeService.createSmartNode(smartNodeDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody ResponseEntity<String> updateSmartNode(@RequestBody SmartNodeUpdateDto smartNodeUpdateDto){

        return smartNodeService.updateSmartNode(smartNodeUpdateDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public @ResponseBody List<SmartNodeDto> getAllSmartNode(){

        return smartNodeService.getAllSmartNodes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byId/{idSmartNode}")
    public @ResponseBody SmartNodeDto getSmartNodeById(@PathVariable(value = "idSmartNode") Integer idSmartNode){

        return smartNodeService.getSmartNodeById(idSmartNode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byLocation")
    public @ResponseBody SmartNodeDto getSmartNodeByLocation(@RequestBody LocationDto locationDto){

        return smartNodeService.getSmartNodeByLocation(locationDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byName/{name}")
    public @ResponseBody SmartNodeDto getSmartNodeByName(@PathVariable(value = "name") String name){

        return smartNodeService.getSmartNodeByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/bySmartCluster")
    public @ResponseBody List<SmartNodeDto> getSmartNodeBySmartCluster(@RequestBody SmartClusterDto smartClusterDto){

        return smartNodeService.getSmartNodeBySmartCluster(smartClusterDto);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byName/{name}")
    public @ResponseBody ResponseEntity<String> deleteSmartNodeByName(@PathVariable(value = "name") String name){

        return smartNodeService.deleteSmartNodeByName(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byId/{id}")
    public @ResponseBody ResponseEntity<String> deleteSmartNodeById(@PathVariable(value = "id") Integer idSmartNode){

        return smartNodeService.deleteSmartNodeById(idSmartNode);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/bySmartCluster")
    public @ResponseBody ResponseEntity<String> deleteSmartNodeBySmartCluster(@RequestBody SmartClusterDto smartClusterDto){

        return smartNodeService.deleteSmartNodeBySmartCluster(smartClusterDto);
    }


}

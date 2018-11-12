package com.sjsu.cmpe.sstreet.mirroringserver.controller.infrastructure_manager;

import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.LocationDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartNodeDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartNodeUpdateDto;
import com.sjsu.cmpe.sstreet.mirroringserver.service.infrastructure_manager.SmartNodeIMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smart_node")
public class SmartNodeIMController {

    private final SmartNodeIMService smartNodeIMService;

    @Autowired
    public SmartNodeIMController(SmartNodeIMService smartNodeIMService) {
        this.smartNodeIMService = smartNodeIMService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public @ResponseBody ResponseEntity<String> createSmartNode(@RequestBody SmartNodeDto smartNodeDto){

        return smartNodeIMService.createSmartNode(smartNodeDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody ResponseEntity<String> updateSmartNode(@RequestBody SmartNodeUpdateDto smartNodeUpdateDto){

        return smartNodeIMService.updateSmartNode(smartNodeUpdateDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public @ResponseBody List<SmartNodeDto> getAllSmartNode(){

        return smartNodeIMService.getAllSmartNodes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byId/{idSmartNode}")
    public @ResponseBody SmartNodeDto getSmartNodeById(@PathVariable(value = "idSmartNode") Integer idSmartNode){

        return smartNodeIMService.getSmartNodeById(idSmartNode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byLocation")
    public @ResponseBody SmartNodeDto getSmartNodeByLocation(@RequestBody LocationDto locationDto){

        return smartNodeIMService.getSmartNodeByLocation(locationDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byName/{name}")
    public @ResponseBody SmartNodeDto getSmartNodeByName(@PathVariable(value = "name") String name){

        return smartNodeIMService.getSmartNodeByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/bySmartCluster")
    public @ResponseBody List<SmartNodeDto> getSmartNodeBySmartCluster(@RequestBody SmartClusterDto smartClusterDto){

        return smartNodeIMService.getSmartNodeBySmartCluster(smartClusterDto);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byName/{name}")
    public @ResponseBody ResponseEntity<String> deleteSmartNodeByName(@PathVariable(value = "name") String name){

        return smartNodeIMService.deleteSmartNodeByName(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/byId/{id}")
    public @ResponseBody ResponseEntity<String> deleteSmartNodeById(@PathVariable(value = "id") Integer idSmartNode){

        return smartNodeIMService.deleteSmartNodeById(idSmartNode);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/bySmartCluster")
    public @ResponseBody ResponseEntity<String> deleteSmartNodeBySmartCluster(@RequestBody SmartClusterDto smartClusterDto){

        return smartNodeIMService.deleteSmartNodeBySmartCluster(smartClusterDto);
    }


}

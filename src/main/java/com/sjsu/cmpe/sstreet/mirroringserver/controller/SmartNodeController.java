package com.sjsu.cmpe.sstreet.mirroringserver.controller;

import com.sjsu.cmpe.sstreet.mirroringserver.model.Location;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartNode;

import com.sjsu.cmpe.sstreet.mirroringserver.service.SmartClusterService;
import com.sjsu.cmpe.sstreet.mirroringserver.service.SmartNodeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smart_node")
public class SmartNodeController {

    private final SmartNodeService smartNodeService;
    private Logger log;
    private SmartClusterService smartClusterService;

    @Autowired
    public SmartNodeController(
        SmartNodeService smartNodeService,
        Logger log,
        SmartClusterService smartClusterService)
    {
        this.smartNodeService = smartNodeService;
        this.log = log;
        this.smartClusterService = smartClusterService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public @ResponseBody ResponseEntity<String> createSmartNode(@RequestBody SmartNode smartNode){

        return smartNodeService.createSmartNode(smartNode);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "application/json")
    public SmartNode updateSmartNode(@RequestBody SmartNode smartNode){

        SmartCluster cluster = smartClusterService.getSmartClusterById(smartNode.getSmartCluster().getIdSmartCluster());
        smartNode.setSmartCluster(cluster);

        return smartNodeService.updateSmartNode(smartNode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public @ResponseBody List<SmartNode> getAllSmartNode(){

        return smartNodeService.getAllSmartNodes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byId/{idSmartNode}")
    public @ResponseBody SmartNode getSmartNodeById(@PathVariable(value = "idSmartNode") Integer idSmartNode){

        return smartNodeService.getSmartNodeById(idSmartNode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byLocation")
    public @ResponseBody SmartNode getSmartNodeByLocation(@RequestBody Location location){

        return smartNodeService.getSmartNodeByLocation(location);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/byName/{name}")
    public @ResponseBody SmartNode getSmartNodeByName(@PathVariable(value = "name") String name){

        return smartNodeService.getSmartNodeByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/bySmartCluster")
    public @ResponseBody List<SmartNode> getSmartNodeBySmartCluster(@RequestBody SmartCluster smartCluster){

        return smartNodeService.getSmartNodeBySmartCluster(smartCluster);
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
    public @ResponseBody ResponseEntity<String> deleteSmartNodeBySmartCluster(@RequestBody SmartCluster smartCluster){

        return smartNodeService.deleteSmartNodeBySmartCluster(smartCluster);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nodes/unregistered", produces = "application/json")
    public List<SmartNode> getUnregisteredNodes(){

        return smartNodeService.getUnregisteredNodes();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/node/registered")
    public void registeredNodeEvent(@RequestBody SmartNode smartNode){
        log.info("Getting node registered event node:{}", smartNode);
        smartNodeService.registeredNodeEvent(smartNode);
    }

}

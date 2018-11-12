package com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql;

import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.LocationDto;
import com.sjsu.cmpe.sstreet.mirroringserver.model.Location;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartNode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SmartNodeRepository extends CrudRepository<SmartNode, Integer> {

    SmartNode findByLocation(Location location);

    List<SmartNode> findBySmartCluster(SmartCluster smartCluster);

    Optional<SmartNode> findByName(String name);

    void deleteByName(String name);

    void deleteBySmartCluster(SmartCluster smartCluster);

}

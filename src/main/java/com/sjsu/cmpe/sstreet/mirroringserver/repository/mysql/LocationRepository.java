package com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql;

import com.sjsu.cmpe.sstreet.webserver.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}

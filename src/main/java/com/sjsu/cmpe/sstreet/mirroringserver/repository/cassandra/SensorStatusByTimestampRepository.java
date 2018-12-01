package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;


import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorStatusByTimestamp;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorStatusByTimestampRepository extends CassandraRepository<SensorStatusByTimestamp,Long> {


    List<SensorStatusByTimestamp> findByTimestampBeforeAndTimestampAfter(Long timestampBefore, Long timestampAfter);

}

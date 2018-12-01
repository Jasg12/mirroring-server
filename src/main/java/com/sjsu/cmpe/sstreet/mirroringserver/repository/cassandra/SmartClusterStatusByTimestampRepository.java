package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartClusterStatusByTimestamp;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartClusterStatusByTimestampRepository extends CassandraRepository<SmartClusterStatusByTimestamp, Long> {


}

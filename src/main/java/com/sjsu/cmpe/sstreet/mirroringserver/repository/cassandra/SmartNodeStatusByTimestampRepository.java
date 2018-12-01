package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartNodeStatusByTimestamp;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartNodeStatusByTimestampRepository extends CassandraRepository<SmartNodeStatusByTimestamp, Long> {
}

package com.sjsu.cmpe.sstreet.mirroringserver;

import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorValueReadingConverter;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorValueWritingConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCassandraRepositories(basePackages = {"com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra"})
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.keyspace}")
    private String keySpaceName;

    @Value("${cassandra.keyspace.startup.script}")
    private String keySpasceScript;

    @Value("${cassandra.contact-points}")
    private String contactPoints;

    @Value("${cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected List<String> getStartupScripts() {
        return Arrays.asList(keySpasceScript);
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.sjsu.cmpe.sstreet.webserver.model"};
    }

    @Override
    public CassandraCustomConversions customConversions() {

        List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

        converters.add(new SensorValueReadingConverter());
        converters.add(new SensorValueWritingConverter());

        return new CassandraCustomConversions(converters);
    }

}

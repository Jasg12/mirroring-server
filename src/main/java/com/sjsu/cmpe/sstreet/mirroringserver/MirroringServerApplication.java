package com.sjsu.cmpe.sstreet.mirroringserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MirroringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MirroringServerApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate(){
	    return new RestTemplate();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Logger logger(){
        return LoggerFactory.getLogger("application");
    }
}

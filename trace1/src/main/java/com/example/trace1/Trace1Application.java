package com.example.trace1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace1Application {

    private static final Logger logger = LoggerFactory.getLogger(Trace1Application.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value="/trace1", method = RequestMethod.GET)
    public String trace(){

        logger.info("========call trace1========");
        return restTemplate().getForEntity(
                "http://trace2/trace2", String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(Trace1Application.class, args);
    }

}

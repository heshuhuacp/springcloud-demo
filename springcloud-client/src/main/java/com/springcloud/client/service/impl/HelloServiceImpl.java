package com.springcloud.client.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        return  restTemplate.getForEntity("http://hello-service/hello",
                String.class).getBody();
    }

    public String helloFallback(){

        return "error";
    }
}

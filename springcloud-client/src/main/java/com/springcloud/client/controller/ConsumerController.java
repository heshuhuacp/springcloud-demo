package com.springcloud.client.controller;

import com.springcloud.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="/ribbonConsumer", method = RequestMethod.GET)
    public String helloConsumer(){

        return helloService.helloService();
    }

}

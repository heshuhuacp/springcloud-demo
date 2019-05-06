package com.springcloud.feign.controller;

import com.springcloud.feign.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springcloud.learn.dto.User;

@RestController
public class ConsumerController {

    @Autowired
    RefactorHelloService refactorHelloService;

//    @Autowired
//    RefactorHelloService refactorHelloService;

//    @RequestMapping(value="/feign-consumer", method = RequestMethod.GET)
//    public String hello(){
//
//        return helloService.hello("XIAODONG");
//    }

    @RequestMapping(value="/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2(){

        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("XIAODONG")).append("\n");
        sb.append(refactorHelloService.hello("XIAODONG", 25)).append("\n");
        sb.append(refactorHelloService.hello(new User("XIAODONG", 25))).append("\n");
        return sb.toString();
    }



}

package com.springcloud.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import springcloud.learn.dto.User;

@Component
@RequestMapping("/fallback")
public class HelloServiceFallback implements RefactorHelloService {


//    @Override
//    public String hello() {
//        return "error";
//    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}

package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import springcloud.learn.dto.User;
import springcloud.learn.service.HelloService;

@RestController
public class RefactorHelloController implements HelloService {

    public String hello(String name) {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

        return "Hello" + name;
    }

    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    public String hello(User user) {
        return "Hello" + user.getName() +", " +user.getAge();
    }
}

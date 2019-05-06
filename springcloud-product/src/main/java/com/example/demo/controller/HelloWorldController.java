package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springcloud.learn.dto.User;

@RestController
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello(){

        return "hello DYR";
    }

    @RequestMapping(value="/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "hello" + name;
    }

    @RequestMapping(value="/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){

        return new User(name, age);
    }

    @RequestMapping(value="/hello3", method = RequestMethod.GET)
    public String hello(@RequestBody User user){

        return "hello" + user.getName() + ", " + user.getAge();
    }


}

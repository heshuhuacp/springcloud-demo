package com.springcloud.feign.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springcloud.learn.dto.User;

//@FeignClient(name="HELLO-SERVICE",fallback = HelloServiceFallback.class)
//public interface HelloService {
//
//    @RequestMapping("/hello")
//    String hello();
//
//    @RequestMapping(value="/hello", method = RequestMethod.GET)
//    public String hello(@RequestParam("name") String name);
//
//    @RequestMapping(value="/hello2", method = RequestMethod.GET)
//    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
//
//    @RequestMapping(value="/hello3", method = RequestMethod.POST)
//    public String hello(@RequestBody User user);
//}

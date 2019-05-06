package com.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import springcloud.learn.service.HelloService;

@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class)
public interface RefactorHelloService extends HelloService {
}

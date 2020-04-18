package com.spring_cloud.provider.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider01Controller {

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String hello(){
        return "hello"+port;
    }

    @GetMapping("/hello1")
    public String hello1(String name){
        return "name，"+port;
    }

}

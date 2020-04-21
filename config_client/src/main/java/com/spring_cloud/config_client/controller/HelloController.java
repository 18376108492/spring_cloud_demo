package com.spring_cloud.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${dan}")
    String dan;

    @GetMapping("/hello")
    public String hello(){
        return dan;
    }
}

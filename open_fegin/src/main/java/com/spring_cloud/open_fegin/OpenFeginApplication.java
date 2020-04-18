package com.spring_cloud.open_fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OpenFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeginApplication.class, args);
    }

}

package com.spring_cloud.open_fegin;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class OpenFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeginApplication.class, args);
    }


    /**
     * 通过配置日志来查看整个请求的流程过程.
     * @return
     */
    @Bean
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }

}

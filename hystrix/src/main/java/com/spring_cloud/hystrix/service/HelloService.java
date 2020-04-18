package com.spring_cloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 发起一个远请求去调用provider的hello方法，
     * 在调用的过程中的可能会出现错误，我们需要使用@HystrixCommand给其添加一个服务降级
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String hello(){
        return restTemplate.getForObject("http://provider/hello",String.class);
    }

    /**
     * 方法名和返回值要保持一致
     * @return
     */
    public String error(){
    return "error";
    }

    /**
     * 通过注解实现请求异步调用
     */
    @HystrixCommand(fallbackMethod = "error")
    public Future<String> hello2(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://privoder/hello",String.class);
            }
        };
    }
}

package com.spring_cloud.hystrix.controller;


import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class HelloCommand extends HystrixCommand<String> {

    @Autowired
    RestTemplate restTemplate;

    protected HelloCommand(Setter setter,RestTemplate restTemplate) {
        super(setter);
        this.restTemplate=restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return  restTemplate.getForObject("http://provider/hello",String.class);
    }

    /**
     * 请求失败的回调方法
     * @return
     */
    @Override
    protected String getFallback() {
        return super.getFallback();
    }
}

package com.spring_cloud.open_fegin.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于UserService出差时的服务降级，
 */
@Component
@RequestMapping("/dan") //防止请求地址冲突
public class UserServiceFallback {

    public List<User> getAllUser(){
        return new ArrayList<>();
    }

    public User getUserByName(String name){
         return null;
    }

}

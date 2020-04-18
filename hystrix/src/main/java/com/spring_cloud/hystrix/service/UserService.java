package com.spring_cloud.hystrix.service;

import com.spring_cloud.hystrix.entry.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public List<User> getUser(List<Integer> ids){
        User[] users = restTemplate.getForObject("http://provider/user/{1}",
                User[].class,
                StringUtils.join(ids, ","));
      return   Arrays.asList(users);
    }

}

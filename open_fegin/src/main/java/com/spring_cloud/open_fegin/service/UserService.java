package com.spring_cloud.open_fegin.service;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "provider",fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user/getAllUser")
     List<User> getAllUser();

    //传递参数
    @GetMapping("/user/getByName")
    User getUserByName(@RequestParam(name = "name")String name);

    @PostMapping("/user/add")
    User addUser(@RequestBody User user);

    @DeleteMapping("/user/{id}")
    Integer deleteUser(@PathVariable(name = "id") Integer id);
}

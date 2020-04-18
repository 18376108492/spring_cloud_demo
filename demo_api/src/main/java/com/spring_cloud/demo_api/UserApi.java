package com.spring_cloud.demo_api;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController

/**
 * 该API接口用来定义openFeign和provider中公共的接口。然后两模块添加的该API依赖。
 */
public interface UserApi {

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

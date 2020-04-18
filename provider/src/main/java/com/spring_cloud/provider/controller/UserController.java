package com.spring_cloud.provider.controller;


import com.spring_cloud.provider.entry.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    /**
     * 获取用户信息操作,假设传递过来的ids=1，2，3 这样的类型
     * @param ids
     * @return
     */
    @GetMapping("/user/{ids}")
    public List<User> getUser(@PathVariable String ids){
        //先获取单个ID
        String[] split = ids.split(",");
        List<User> users=new ArrayList<>();
        for (String id :split) {
            //创建用户模拟数据
            User u=new User();
            u.setId(Integer.parseInt(id));
            users.add(u);
        }
        return users;

    }

}

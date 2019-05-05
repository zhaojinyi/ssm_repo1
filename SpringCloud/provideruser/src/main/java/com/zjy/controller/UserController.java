package com.zjy.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zjy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/9
 * @Description: com.zjy.controller
 */
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable  Long id){
        return new User(id);
    }

    @GetMapping("/eurekaInfo")
    public String info(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @PostMapping("/get-user")
    public User getUser(@RequestBody User user){
        // 相当于我么恩传递的是一个复杂的参数被封装成的对象，然后我们将封装的对象返回，也就是你传过来什么我给你传回去
        return user;
    }

}

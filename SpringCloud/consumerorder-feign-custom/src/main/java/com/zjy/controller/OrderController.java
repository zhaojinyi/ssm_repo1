package com.zjy.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zjy.feign.FeignClient01;
import com.zjy.feign.FeignClient02;
import com.zjy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/9
 * @Description: com.zjy.controller
 */
@RestController
public class OrderController {

    @Autowired
    private FeignClient01 feignClient01;

    @Autowired
    private FeignClient02 feignClient02;

    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id){

        User user = feignClient01.getOrder(id);

        return user;
    }

    @GetMapping("/get-user/{id}")
    public User getUserByUser(@PathVariable Long id){
        User user = new User(id);
        System.out.println(user);
        User user1 = feignClient01.getUser(user);
        System.out.println(user1);
        return user1;
    }

    @RequestMapping("/serviceInfo/{name}")
    public String getServiceInfo(@PathVariable String name){
        return feignClient02.getServiceInfo(name);
    }
}

package com.zjy.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/9
 * @Description: com.zjy.controller
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;  //spring提供的用于访问rest接口的模板对象
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${user.url}")
    private String url;
    //private String url = "http://localhost:7900/user/";
    @GetMapping("/order/{id}")
    @HystrixCommand(fallbackMethod = "shibai",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            }
    ) // execution.islocation.strategy  是不建议修改的  如果遇到问题在修改，没有遇到不修改
    public User getOrder(@PathVariable Long id){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        String homePageUrl = instance.getHomePageUrl();
        //通过访问rest获取到json对象，然后转换到User类中
        User user = restTemplate.getForObject(homePageUrl+"/user/" + id, User.class);
        return user;
    }

    /**
     * 失败是执行的回调
     * @param id
     * @return
     */
    public User shibai(Long id){
        User user = new User();
        user.setId(-100L);
        user.setDate(new Date());
        return user;
    }
}

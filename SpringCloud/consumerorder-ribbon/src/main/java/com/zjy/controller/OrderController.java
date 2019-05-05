package com.zjy.controller;

import com.netflix.discovery.EurekaClient;
import com.zjy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Value("${user.url}")
    private String url;
    //private String url = "http://localhost:7900/user/";
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id){
        //访问提供者，获取资源
        // 通过访问rest获取到json数据，然后转换为user格式
        /*InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        String homePageUrl = instance.getHomePageUrl();*/
        //通过访问rest获取到json对象，然后转换到User类中
        User user = restTemplate.getForObject("http://PROVIDER-USER/user/" + id, User.class);
        return user;
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance choose = loadBalancerClient.choose("PROVIDER-USER");  //查找对应服务的实例，会通过负载均衡的算法返回一个服务
        System.out.println("11111"+choose.getServiceId()+choose.getHost()+":"+choose.getPort());


        ServiceInstance choose1 = loadBalancerClient.choose("PROVIDER-USER1");  //查找对应服务的实例，会通过负载均衡的算法返回一个服务
        System.out.println("22222"+choose1.getServiceId()+choose1.getHost()+":"+choose1.getPort());
        return "1";
    }
}

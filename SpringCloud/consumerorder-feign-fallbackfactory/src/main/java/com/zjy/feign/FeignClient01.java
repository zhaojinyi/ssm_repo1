package com.zjy.feign;

import com.zjy.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/10
 * @Description: com.zjy.feign
 */
@FeignClient(name="provider-user", fallbackFactory = HystrixClientFallbackFactory.class)
public interface FeignClient01 {

    //@GetMapping("/user/{id}")   //C版本的spring不能使用getMapping， 必须使用requestMapping
    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    User getOrder(@PathVariable("id") Long id);  //注意 必须添加@PathVariable("id")注解

    //  无法访问，提供者那边必须是以post方式这边才可以使用，如果非要使用get传递多个数据，只能多个多个数据，不能封装为复杂对象
    @RequestMapping(value = "/get-user", method = RequestMethod.POST)
    User getUser(@RequestBody User user);  //如果你传递的是复杂参数，那么feign不管你设置的是什么请求方式，都会以post的方式传递出去

}

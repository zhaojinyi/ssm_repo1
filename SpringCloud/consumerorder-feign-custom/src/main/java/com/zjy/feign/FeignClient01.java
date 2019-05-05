package com.zjy.feign;

import com.config.FeignClient01Config;
import com.zjy.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/10
 * @Description: com.zjy.feign
 */
@FeignClient(name="provider-user", configuration = FeignClient01Config.class)
public interface FeignClient01 {

    @RequestLine("GET /user/{id}")  // 组合注解，第一个是请求方式，第二个是参数， 用空格分开
    User getOrder(@Param("id") Long id);  //注意 必须添加@Param() 注解

    //@RequestMapping(value = "/get-user", method = RequestMethod.POST)
    @RequestLine("GET /get-user")
    User getUser(@RequestBody User user);  //如果你传递的是复杂参数，那么feign不管你设置的是什么请求方式，都会以post的方式传递出去

}

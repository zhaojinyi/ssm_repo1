package com.zjy.feign;

import com.config.FeignClient01Config;
import com.config.FeignClient02Config;
import com.zjy.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/10
 * @Description: com.zjy.feign
 */
@FeignClient(name="wedw", url="http://localhost:10000/", configuration = FeignClient02Config.class)
public interface FeignClient02 {

    @RequestMapping("/eureka/apps/{servicename}")
    String getServiceInfo(@PathVariable("servicename") String servicename);

}

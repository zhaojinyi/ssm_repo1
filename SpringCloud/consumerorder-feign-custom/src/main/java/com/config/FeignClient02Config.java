package com.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/10
 * @Description: com.config
 */
@Configuration
public class FeignClient02Config {

    /**
     * 用于创建用户名和密码的对象
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user", "812912");
    }

    /**
     * 配置要输出的日志是那些，必须在debug模式下才可以输出
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}

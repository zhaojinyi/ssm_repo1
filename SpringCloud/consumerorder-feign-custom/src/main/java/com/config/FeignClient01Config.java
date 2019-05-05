package com.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/10
 * @Description: com.config
 */
@Configuration
public class FeignClient01Config {

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}

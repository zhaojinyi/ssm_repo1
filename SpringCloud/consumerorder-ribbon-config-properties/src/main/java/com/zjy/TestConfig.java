package com.zjy;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/9
 * @Description: com
 */
@Configuration
@ExcludeCommentScan   //  排除扫描
public class TestConfig {

    @Autowired
    IClientConfig clientConfig;

    /**
     * 创建负载均衡算法
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();  // 返回随机算法
    }

}

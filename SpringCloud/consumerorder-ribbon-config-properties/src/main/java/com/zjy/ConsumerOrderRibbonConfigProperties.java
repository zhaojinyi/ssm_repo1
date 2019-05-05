package com.zjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="PROVIDER-USER", configuration = TestConfig.class)  // 启动ribbon并对provider-user 进行负载均衡
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeCommentScan.class)})
public class ConsumerOrderRibbonConfigProperties
{

    // 相当于xml中配置了一个Bean标签，主要是用于调用当前方法获取到指定对象
    @Bean
    public RestTemplate getTemp(){
        return new RestTemplate();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerOrderRibbonConfigProperties.class);
    }
}

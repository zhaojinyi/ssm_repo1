package com.zjy.config;////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//            佛祖保佑       永不宕机     永无BUG                    	  //
////////////////////////////////////////////////////////////////////

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/11
 *
 *完成对redis 的整合
 *
 * @Description: com.zjy.config
 */
@Configuration
public class RedisConfig {

    /**
     * 创建 jedisPoolConfig 对象，在该对象中完成一些连接池配置
     *
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
//
//        //最大空闲数
//        config.setMaxIdle(10);
//        // 最小空闲数
//        config.setMinIdle(5);
//        // 最大连接数
//        config.setMaxTotal(20);

        System.out.println("默认值："+config.getMaxIdle());
        System.out.println("默认值："+config.getMinIdle());
        System.out.println("默认值："+config.getMaxTotal());
        return config;
    }

    /**
     * 创建JedisConnectionFactory：配置redis的连接信息
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
        System.out.println("配置完毕："+config.getMaxIdle());
        System.out.println("配置完毕："+config.getMinIdle());
        System.out.println("配置完毕："+config.getMaxTotal());

        JedisConnectionFactory factory = new JedisConnectionFactory();
        // 关联连接池的配置对象
        factory.setPoolConfig(config);
//        //配置连接redis的信息
//        factory.setHostName("192.168.31.166");
//        factory.setPort(6379);
        System.out.println("配置完毕："+factory.getHostName());
        return factory;
    }

    /**
     * 创建redisTemplate： 用于执行redis的操作方法
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        //  关联
        template.setConnectionFactory(factory);
        //为key 设置序列化器
        template.setKeySerializer(new StringRedisSerializer());

        // 为 value 设置序列化器
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }
}

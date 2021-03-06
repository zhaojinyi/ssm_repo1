package com.zjy;

import static org.junit.Assert.assertTrue;

import com.zjy.pojo.Users;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSet() {
        this.redisTemplate.opsForValue().set("key123", "北京尚学堂123");
    }

    /**
     * 获取一个字符串
     */
    @Test
    public void testGet() {
        String value = (String) this.redisTemplate.opsForValue().get("key123");
        System.out.println(value);
    }

    /**
     * 添加USer
     */
    @Test
    public void testSetUsers() {
        Users users = new Users();
        users.setName("123");
        users.setId(1);
        users.setAge(23);
        // 重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("users", users);
    }

    /**
     * 获取Users
     */
    @Test
    public void testGetUsers() {
        // 重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        Users users = (Users) this.redisTemplate.opsForValue().get("users");

        System.out.println(users);
    }

    /**
     * 基于 JSON 格式存 Users 对象
     */
    @Test
    public void testSetUsersUseJSON() {
        Users users = new Users();
        users.setAge(20);
        users.setName("李四丰");
        users.setId(1);
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        this.redisTemplate.opsForValue().set("users_json", users);
    }

    /**
     * 基于 JSON 格式取 Users 对象
     */
    @Test
    public void testGetUseJSON() {
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Users users = (Users) this.redisTemplate.opsForValue().get("users_json");
        System.out.println(users);
    }
}

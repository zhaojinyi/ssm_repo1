package com.zjy;

import com.zjy.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


/**
 * springboot 测试类
 * @RunWith   启动器
 *  springJunit4ClassRunner.class   让junit和spring环境进行整合
 *
 * @SpringbootTest(classes=App.class)  当前类为springboot的测试类
 * @SpringbootTest(classes=App.class)   当前类为springboot的启动类
 *、
 * Junit与spring整合  @Contextconfiguration（"classpath:applicationContext.xml"）
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest 
{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testAddUSer(){
        this.userServiceImpl.addUser();
    }
}

package com.zjy;

import com.zjy.domain.User;
import com.zjy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/3
 * @Description: com.zjy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll(){
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }
    @Test
    public void testFindById(){
        User user = userService.findById(1);
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        User user = userService.findById(1);
        System.out.println("修改之前的用户：----"+user);

        user.setAge(11);
        userService.updateUser(user);

        user = userService.findById(1);
        System.out.println("修改之后的用户：----"+user);
    }

}

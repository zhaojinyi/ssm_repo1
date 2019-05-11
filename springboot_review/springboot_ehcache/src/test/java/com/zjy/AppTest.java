package com.zjy;

import static org.junit.Assert.assertTrue;

import com.zjy.pojo.Users;
import com.zjy.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest 
{
    @Autowired
    private UsersService usersService;

    @Test
    public void testFindUsersById(){
        //  第一次查询
        System.out.println(this.usersService.findUserById(1));


        //  第二次查询
        System.out.println(this.usersService.findUserById(1));

    }

    @Test
    public void testFindUsersByPage(){

        Pageable pageable = new PageRequest(0, 2);

        //  第一次查询
        System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());

        //  第一次查询
        System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());

        pageable = new PageRequest(1, 2);

        //  第一次查询
        System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
    }

    @Test
    public void testFindAll(){
        //第一次查询
        System.out.println(this.usersService.findUserAll().size());

        Users users = new Users();
        users.setAddress("南京");
        users.setAge(43);
        users.setName("张三");
        this.usersService.saveUsers(users);
        //第二次查询
        System.out.println(this.usersService.findUserAll().size());


    }

}

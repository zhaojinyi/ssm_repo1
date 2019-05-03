package com.zjy.dao;

import com.zjy.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/3
 * @Description: com.zjy.dao
 */
public interface UserDao {

    /**
     * 查询用户列表
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据用户id查询
     */
    @Select("select * from user where id = #{userId}")
    User findById(Integer userId);

    /**
     * 更新用户
     */
    @Update("update user set username=#{username}, password=#{password}, sex=#{sex}, age=#{age}, email=#{email} where id=#{id}")
    void updateUser(User user);

}

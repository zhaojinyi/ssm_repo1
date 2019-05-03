package com.zjy.service;

import com.zjy.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/3
 * @Description: com.zjy.service
 */
public interface UserService {

    /**
     * 查询用户列表
     */
    List<User> findAll();

    /**
     * 根据用户id查询
     */
    User findById(Integer userId);

    /**
     * 更新用户
     */
    void updateUser(User user);

}

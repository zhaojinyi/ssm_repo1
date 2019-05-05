package com.zjy.feign;

import com.zjy.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/12
 * @Description: com.zjy.feign
 */
@Component
public class FeignClient01Hystrix implements FeignClient01 {
    @Override
    public User getOrder(Long id) {
        User user = new User();
        user.setId(-300L);
        user.setDate(new Date());
        return user;
    }

    @Override
    public User getUser(User user) {
        return user;
    }
}

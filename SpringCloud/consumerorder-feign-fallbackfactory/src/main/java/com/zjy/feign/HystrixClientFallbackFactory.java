package com.zjy.feign;

import com.zjy.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/12
 * @Description: com.zjy.feign
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<FeignClient01> {
    @Override
    public FeignClient01 create(Throwable throwable) {
        return new FeignClient01() {
            @Override
            public User getOrder(Long id) {
                User user = new User();
                user.setId(-500L);
                user.setDate(new Date());
                return user;
            }

            @Override
            public User getUser(User user) {
                return user;
            }
        };
    }
}

package com.zjy.service;

import com.zjy.domain.Items;
import org.springframework.stereotype.Service;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.service
 */
public interface ItemService {

    public Items findById(Integer id);

}

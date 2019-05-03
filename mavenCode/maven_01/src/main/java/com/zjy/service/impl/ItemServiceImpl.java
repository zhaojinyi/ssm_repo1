package com.zjy.service.impl;

import com.zjy.dao.ItemDao;
import com.zjy.domain.Items;
import com.zjy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.service.impl
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public Items findById(Integer id) {

        return itemDao.findById(id);
    }
}

package com.zjy.test;

import com.zjy.dao.ItemDao;
import com.zjy.domain.Items;
import com.zjy.service.ItemService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.test
 */
public class ItemTest {

    @Test
    public void findById() {
        //  获取spring容器    dao测试
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ItemDao itemDao = ac.getBean(ItemDao.class);
//        Items item = itemDao.findById(1);
//        System.out.println(item.getName());

        ItemService itemService = ac.getBean(ItemService.class);
        Items items = itemService.findById(1);
        System.out.println(items.getName());
    }

}

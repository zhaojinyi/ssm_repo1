package com.zjy.controller;

import com.zjy.domain.Items;
import com.zjy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/findDetail")
    public String findDetail(Model model) {
        Items items = itemService.findById(1);
        model.addAttribute("item", items);
        return "itemDetail";
    }

}

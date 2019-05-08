package com.zjy.controller;////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//            佛祖保佑       永不宕机     永无BUG                    	  //
////////////////////////////////////////////////////////////////////

import com.zjy.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/8
 * @Description: com.zjy.controller
 */
@Controller
public class DemoController {

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg", "这是一个thymeleaf模板");
        return "index";
    }
    @RequestMapping("show1")
    public String showUser(Model model) {
        List<Users> list = new ArrayList<>();
        list.add(new Users(1, "张三1", 12));
        list.add(new Users(2, "张三2", 14));
        list.add(new Users(3, "张三3", 45));
        list.add(new Users(4, "张三4", 23));

        System.out.println(list);
        model.addAttribute("list", list);
        return "index";

    }
}

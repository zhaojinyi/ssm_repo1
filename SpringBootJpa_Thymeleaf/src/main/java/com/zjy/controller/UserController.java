package com.zjy.controller;


import com.zjy.entity.User;
import com.zjy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/6
 * @Description: com.zjy.controller
 */////////////////////////////////////////////////////////////////////
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

/**
 * return "user/list" 是直接去resources下去找相关的文件
 * return "redirect:/list" 代表转发到对应的Controller， 这个就相当于执行完操作后直接调用list请求，然后在输出到页面
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/12")
    @ResponseBody
    public String ng() {
        return "123";
    }


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
        User userById = userService.findUserById(id);
        model.addAttribute("user", userById);
        return "user/userEdit";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("list")
    public String list(Model model) {
        System.out.println("-----------------------");
        List<User> userList = userService.getUserList();
        System.out.println(userList);
        model.addAttribute("users", userList);
        return "user/list";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }

}

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

import com.zjy.pojo.Users;
import com.zjy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/8
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/findAll")
    public String findUserAll(Model model){
        List<Users> list = this.usersService.findAll();
        model.addAttribute("list", list);
        return "showUsers";
    }

    @RequestMapping("/findById")
    public String findUserAll(Integer id,Model model){

        Users users = this.usersService.findById(id);
        model.addAttribute("user", users);
        return "updateUser";
    }

    @RequestMapping("/{page}")
    private String showPage(@PathVariable String page) {
        System.out.println(page);
        return page;
    }

    @RequestMapping("/addUser")
    public String addUser(Users users){
        System.out.println(users);
        this.usersService.insertUser(users);
        return "redirect:/users/findAll";
    }

    @RequestMapping("/editUser")
    public String editUser(Users users){
        this.usersService.updateUser(users);
        return "redirect:/users/findAll";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        this.usersService.deletebyId(id);
        return "redirect:/users/findAll";
    }

}

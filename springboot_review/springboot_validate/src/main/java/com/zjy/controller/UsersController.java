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
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/8
 * @Description: com.zjy.controller
 */
@Controller
public class UsersController {

    /**
     * @NotBlank   判断字符串是否为null或者是空串
     * @NotEmpty   判断字符串是否null或者是空串
     * @Length     判断字符串的长度（最大或最小）
     * @Min        判断数值最小值
     * @Max        判断数值最大值
     * @Email      判断邮箱是否合法
     */

    /**java.lang.IllegalStateException: Neither BindingResult nor plain target object for bean name 'users' available as request attribute
     *
     * 解决异常的方式:
     *  可以再页面跳转的方法中注入一个users对象，
     *  注意：  由于springMVC会将该对象放入到MOdel 中传递，key的名称回事呀该对象的驼峰式的命名规则来作为key
     *  参数的变量名需要与对象的名称相同，，将首字母小写
     * @return
     */
    @RequestMapping("/addUser")
    public String showPage(Users users){
        return "add";
    }

    /**
     * 完成用户添加
     *
     * @Vaild  开启对Users对象的数据校验
     * BingingResult  封装了校验的结果
     * @param users
     * @return
     */
    @RequestMapping("/save")
    public String saveUser(@Valid Users users, BindingResult result){
        if(result.hasErrors()){
            return "add";
        }
        System.out.println(users);
        return "ok";
    }

}

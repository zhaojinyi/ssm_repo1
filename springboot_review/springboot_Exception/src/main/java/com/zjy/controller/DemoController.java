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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/8
 * @Description: com.zjy.controller
 */
@Controller
public class DemoController {

    @RequestMapping("/show")
    public String showInfo(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int a = 10/0;
        return "index";
    }

//    /**  第一种方法
//     * 该方法需要返回一个ModelAndView， 目的是让我们可以封装异常信息以及视图的指定
//     * 参数  e   会将产生的异常对象注入到方法中
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value={java.lang.ArithmeticException.class})
//    public ModelAndView arithmeticException(Exception e){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error1");
//        return mv;
//    }
//
//    @ExceptionHandler(value={java.lang.NullPointerException.class})
//    public ModelAndView nullPointException(Exception e){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error2");
//        return mv;
//    }
}

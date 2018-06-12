package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 处理登录请求
 * User: monkey
 * Date: 2018-06-12 9:14
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //登录界面
    @RequestMapping(value = "/index")
    public String loginPage(){
        return "login";
    }

    //处理登录逻辑
    @RequestMapping(value = "/loginCheck")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser=userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if (!isValidUser){
            //参数一：试图的逻辑名称，参数二：数据模型的名称，参数三：数据模型对象
            //数据模型对象将以数据模型名称为参数名放置到request的属性中
            return new ModelAndView("login","error","用户名或密码错误");
        }else {
            User user=userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);

            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }

}

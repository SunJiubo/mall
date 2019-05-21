package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path ={"/user"} )
public class UserLoginController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/toreg"}, method = {RequestMethod.GET})
    public String toreg() {
        return "user/reg";
    }

    @RequestMapping(path = {"/reg"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String reg(User user, HttpServletRequest req) {
        userService.insertUser(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        System.out.println(user);
        return "homepage/home";
    }

    @RequestMapping(value = "tologin")
    public String tologin() {
        return "user/login";
    }

    @RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(HttpServletRequest req,
                        @RequestParam(value = "account") String account,
                        @RequestParam(value = "password") String password,
                        Model model) {
        String r1 = "homepage/error";
        String err = "";
        User user = userService.queryUserByAccount(account);
        if(user==null){
            err = "用户名不存在";
            System.out.println(err);
            model.addAttribute("errorinfo",err);
            return "homepage/error";
        }else if(!user.getPassword().equals(password)){
            err="密码错误";
            System.out.println(err);
            model.addAttribute("errorinfo",err);
            return "homepage/error";
        }else {
            HttpSession sess = req.getSession();
            sess.setAttribute("user", user);
            r1 = "homepage/home";
        }
        return r1;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return "homepage/home";
    }
}
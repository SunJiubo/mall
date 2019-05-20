package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.MerchantService;
import com.nineboy.seckill.service.UserService;
import com.nineboy.seckill.vo.MerchantVO;
import com.nineboy.seckill.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path ={"/user"} )
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/toadd"}, method = {RequestMethod.GET})
    public String toadd() {
        return "user/add";
    }

    @RequestMapping(path ={"/add"},method = {RequestMethod.GET,RequestMethod.POST})
    public String add(User user){
        userService.insertUser(user);
        System.out.println(user);
        return "redirect:querybyvo";
    }

    @RequestMapping(path = {"/toupdate"}, method = {RequestMethod.GET})
    public String toupdate(Model model,
                           @RequestParam("id") int id) {
        User user  = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "user/update";
    }

    @RequestMapping(path = {"/update"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String update(Model model,User user) {
        userService.updateUser(user);
        System.out.println(user);
        return "redirect:querybyvo";
    }

    @RequestMapping(path = {"/querybyvo"}, method = {RequestMethod.GET})
    public String querybyvo(Model model,
                            UserVO userVO) {
        List<User> list = userService.queryUserByVo(userVO);
        model.addAttribute("list",list);
        return "user/list";
    }

    @RequestMapping(path = {"/querybyid"}, method = {RequestMethod.GET})
    public String querybyid(Model model,
                            @Param("id") int id) {
        User user = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "user/view";
    }

    @RequestMapping(path = {"/del"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String del(@RequestParam("id") int id) {
        userService.deleteUserById(id);
        return "redirect:querybyvo";
    }

}

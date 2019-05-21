package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.service.MerchantService;
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
@RequestMapping(path ={"/merchant"} )
public class MerchantLoginController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    MerchantService merchantService;

    @RequestMapping(path = {"/toreg"}, method = {RequestMethod.GET})
    public String toreg() {
        return "merchant/reg";
    }

    @RequestMapping(path = {"/reg"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String reg(Merchant merchant, HttpServletRequest req) {
        merchantService.insertMerchant(merchant);
        HttpSession session = req.getSession();
        session.setAttribute("merchant", merchant);
        System.out.println(merchant);
        return "adminhomepage/adminhome";
    }

    @RequestMapping(value = "tologin")
    public String tologin() {
        return "merchant/login";
    }

    @RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(HttpServletRequest req,
                        @RequestParam(value = "merchantAccount") String merchantAccount,
                        @RequestParam(value = "merchantPassword") String merchantPassword,
                        Model model) {
        String r1 = "adminhomepage/adminerror";
        String err = "";
        Merchant merchant = merchantService.queryMerchantByAccount(merchantAccount);
        if(merchant==null){
            err = "商家不存在";
            System.out.println(err);
            model.addAttribute("errorinfo",err);
            return "adminhomepage/adminerror";
        }else if(!merchant.getMerchantPassword().equals(merchantPassword)){
            err="密码错误";
            System.out.println(err);
            model.addAttribute("errorinfo",err);
            return "adminhomepage/adminerror";
        }else {
            HttpSession sess = req.getSession();
            sess.setAttribute("merchant", merchant);
            r1 = "adminhomepage/adminhome";
        }
        return r1;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.removeAttribute("merchant");
        return "adminhomepage/adminhome";
    }
}
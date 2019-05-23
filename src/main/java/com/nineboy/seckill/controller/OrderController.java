package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.model.Order;
import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.OrderService;
import com.nineboy.seckill.service.ProductInfoService;
import com.nineboy.seckill.service.pay.WeixinPay;
import com.nineboy.seckill.service.pay.YinlianPay;
import com.nineboy.seckill.service.pay.ZhifubaoPay;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ZhifubaoPay zhifubaoPay;

    @Autowired
    WeixinPay weixinPay;

    @Autowired
    YinlianPay yinlianPay;

    @RequestMapping("payorder")
    public String payorder(Order order){
        Date now = new Date();
        order.setCreateTime(now);
        int paystate =1 ;
        order.setPayStatus(paystate);
        String tradeserialnumber = UUID.randomUUID().toString();
        order.setTradeserialNumber(tradeserialnumber);
        orderService.insertOrder(order);
        return "redirect:/homepage/";
    }

    @RequestMapping("topayorder")
    public String topayorder(HttpServletRequest req ,
                             Model model,
                             @RequestParam("id") int id,
                             @RequestParam("num") int num){
        ProductInfo productInfo = productInfoService.queryProductInfoById(id);
        model.addAttribute("productInfo",productInfo);
        model.addAttribute("num",num);
        int payamount = num * productInfo.getSeckillPrice();
        model.addAttribute("payamount",payamount);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("userId",user.getId());
        }else {
            model.addAttribute("error","未登录");
//            String redirect = "redirect:/user/tologin?next=/order/topayorder?num=2&id=5";
//            return redirect;
            return "redirect:/user/tologin";
        }

        return "order/payorder";
    }

    @RequestMapping("queryorderbyuserid")
    public String queryoOrderByUserId(HttpServletRequest req,
                                      Model model){
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            List<Order> list = orderService.queryOrderByUserId(user.getId());
            model.addAttribute("list",list);
        }else {
            model.addAttribute("error","未登录");
            return "redirect:/user/tologin";
        }
        return "order/listorder";
    }

    @RequestMapping("queryorderbymerchanid")
    public String queryorderbyMerchanid(HttpServletRequest req,
                                        Model model){
        HttpSession session = req.getSession();
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(merchant!=null){
            List<Order> list = orderService.queryOrderByMerchantId(merchant.getId());
            model.addAttribute("list",list);
        }else {
            model.addAttribute("error","未登录");
            return "redirect:/merchant/tologin";
        }
        return "order/listorderwithmerchant";
    }

    @RequestMapping(value = "topaywithorder")
    public String toPaywithOrder(Model model,
                                 @RequestParam("id") int id,
                                 @RequestParam("tradeserialNumber") String tradeserialNumber,
                                 @RequestParam("payAmount") int payAmount){
        model.addAttribute("id", id);
        model.addAttribute("tradeserialNumber", tradeserialNumber);
        model.addAttribute("payAmount", payAmount);
        return "order/payreal";

    }

    @RequestMapping(value = "paywithorder")
    public String PaywithOrder(@RequestParam("payType") int payType,
                               @RequestParam("id") int id,
                               @RequestParam("tradeserialNumber") String tradeserialNumber,
                               @RequestParam("payAmount") int payAmount){
        int paystatus=2;
        if(payType==1){
            paystatus=zhifubaoPay.paywithorder(tradeserialNumber,payAmount);
        }else if(payType==2){
            paystatus=weixinPay.paywithorder(tradeserialNumber,payAmount);
        }else if(payType==3){
            paystatus=yinlianPay.paywithorder(tradeserialNumber,payAmount);
        }

        if(paystatus==1){
            orderService.updateOrderPaystatusById(2,id,payType);
        }

        return "redirect:queryorderbyuserid";
    }

    @RequestMapping("applyrefund")
    public String applyRefund(HttpServletRequest req,
                              Model model,
                              @RequestParam("payType") int payType,
                              @RequestParam("id") int id){
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            orderService.updateOrderPaystatusById(4,id,payType);
        }else {
            model.addAttribute("error","未登录");
            return "redirect:/user/tologin";
        }
        return "redirect:queryorderbyuserid";
    }

    @RequestMapping(value = "auditrefund")
    public String auditRefund(HttpServletRequest req,
                              Model model,
                              @RequestParam("payType") int payType,
                              @RequestParam("id") int id,
                              @RequestParam("tradeserialNumber") String tradeserialNumber,
                              @RequestParam("payAmount") int payAmount,
                              @RequestParam("payStatus") int payStatus){
        HttpSession session = req.getSession();
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(merchant!=null) {
            if(payStatus==3){
                int paystatustmp = 2;
                if (payType == 1) {
                    paystatustmp = zhifubaoPay.refundwithorder(tradeserialNumber, payAmount);
                } else if (payType == 2) {
                    paystatustmp = weixinPay.refundwithorder(tradeserialNumber, payAmount);
                } else if (payType == 3) {
                    paystatustmp = yinlianPay.refundwithorder(tradeserialNumber, payAmount);
                }
                if(paystatustmp==1){
                    orderService.updateOrderPaystatusById(payStatus,id,payType);
                }
            }else if(payStatus==5){
                orderService.updateOrderPaystatusById(payStatus,id,payType);
            }
        }else {
            model.addAttribute("error","未登录");
            return "redirect:/merchant/tologin";
        }
        return "redirect:queryorderbyuserid";
    }
}

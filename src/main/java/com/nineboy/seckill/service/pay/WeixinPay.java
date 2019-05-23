package com.nineboy.seckill.service.pay;

import org.springframework.stereotype.Service;

@Service
public class WeixinPay implements OrdertoPay{
    @Override
    public int paywithorder(String tradeserialNumber, int payAmount) {
        System.out.println("微信支付成功");
        return 1;
    }

    @Override
    public int refundwithorder(String tradeserialNumber, int payAmount) {
        System.out.println("微信退款成功");
        return 1;
    }
}

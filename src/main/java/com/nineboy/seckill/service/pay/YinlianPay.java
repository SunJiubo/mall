package com.nineboy.seckill.service.pay;

import org.springframework.stereotype.Service;

@Service
public class YinlianPay implements OrdertoPay{
    @Override
    public int paywithorder(String tradeserialNumber, int payAmount) {
        System.out.println("银联支付成功");
        return 1;
    }

    @Override
    public int refundwithorder(String tradeserialNumber, int payAmount) {
        System.out.println("银联退款成功");
        return 1;
    }
}

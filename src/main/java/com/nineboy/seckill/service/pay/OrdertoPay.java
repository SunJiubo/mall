package com.nineboy.seckill.service.pay;

public interface OrdertoPay {

    public int paywithorder(String tradeserialNumber, int payAmount);

    public int refundwithorder(String tradeserialNumber, int payAmount);

}

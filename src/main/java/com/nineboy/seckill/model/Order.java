package com.nineboy.seckill.model;

import java.util.Date;

public class Order {

    private int id;//主键
    private int productId;//商品id
    private int payAmount;//支付金额
    private int userId;//用户id
    private int merchantId;//商家id
    private Date createTime;//创建时间
    private Date payTime;//֧支付时间
    private int payStatus;//֧支付状态 1，未支付，2，已支付，3，退款成功
    private String receiverAddress;//收货人地址
    private String receiverName;//收件人姓名
    private String receiverPhone;//收件人电话
    private String tradeserialNumber;//交易流水号
    private int num;//购买数量
    private int payType;//支付方式

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getTradeserialNumber() {
        return tradeserialNumber;
    }

    public void setTradeserialNumber(String tradeserialNumber) {
        this.tradeserialNumber = tradeserialNumber;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }
}

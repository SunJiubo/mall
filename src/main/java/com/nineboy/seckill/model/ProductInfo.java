package com.nineboy.seckill.model;

import java.util.Date;

/**
 * 商品信息
 */
public class ProductInfo {
    private int id;
    private int productId;
    private String productTitle;//商品标题
    private String productPicture;//商品图片地址
    private int seckillPrice;//秒杀价格
    private int originalPrice;//原价格
    private int merchantId;//商家id
    private Date applyDate;//申请时间
    private Date auditDate;//审核时间
    private int auditState;//审核状态
    private Date startTime;//秒杀开始时间
    private Date endTime;//结束时间
    private String startTimeString;
    private String endTimeString;
    private int productCount;//秒杀数量
    private int stockCount;//库存
    private String description;//商品描述

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

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public int getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(int seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productPicture='" + productPicture + '\'' +
                ", seckillPrice=" + seckillPrice +
                ", originalPrice=" + originalPrice +
                ", merchantId=" + merchantId +
                ", applyDate=" + applyDate +
                ", auditDate=" + auditDate +
                ", auditState=" + auditState +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startTimeString='" + startTimeString + '\'' +
                ", endTimeString='" + endTimeString + '\'' +
                ", productCount=" + productCount +
                ", stockCount=" + stockCount +
                ", description='" + description + '\'' +
                '}';
    }

    public ProductInfo(int productId, String productTitle, String productPicture, int seckillPrice, int originalPrice, int merchantId, Date applyDate, Date auditDate, int auditState, Date startTime, Date endTime, int productCount, int stockCount, String description) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPicture = productPicture;
        this.seckillPrice = seckillPrice;
        this.originalPrice = originalPrice;
        this.merchantId = merchantId;
        this.applyDate = applyDate;
        this.auditDate = auditDate;
        this.auditState = auditState;
        this.startTime = startTime;
        this.endTime = endTime;
        this.productCount = productCount;
        this.stockCount = stockCount;
        this.description = description;
    }

    public ProductInfo() {
    }
}

package com.nineboy.seckill.vo;

import com.nineboy.seckill.model.ProductInfo;

import java.util.Date;

public class ProductInfoVO extends ProductInfo {
    private int startSeckillPrice;
    private int endSeckillPrice;

    private int startOriginalPrice;
    private int endOriginalPrice;

    private String startApplyDate;
    private String endApplyDate;

    private String startAuditDate;
    private String endAuditDate;

    private String startStartTime;
    private String endStartTime;

    private String startEndTime;
    private String endEndTime;

    private int startProductCount;
    private int endProductCount;

    private int startStockCount;
    private int endStockCount;

    public int getStartSeckillPrice() {
        return startSeckillPrice;
    }

    public void setStartSeckillPrice(int startSeckillPrice) {
        this.startSeckillPrice = startSeckillPrice;
    }

    public int getEndSeckillPrice() {
        return endSeckillPrice;
    }

    public void setEndSeckillPrice(int endSeckillPrice) {
        this.endSeckillPrice = endSeckillPrice;
    }

    public int getStartOriginalPrice() {
        return startOriginalPrice;
    }

    public void setStartOriginalPrice(int startOriginalPrice) {
        this.startOriginalPrice = startOriginalPrice;
    }

    public int getEndOriginalPrice() {
        return endOriginalPrice;
    }

    public void setEndOriginalPrice(int endOriginalPrice) {
        this.endOriginalPrice = endOriginalPrice;
    }

    public String getStartApplyDate() {
        return startApplyDate;
    }

    public void setStartApplyDate(String startApplyDate) {
        this.startApplyDate = startApplyDate;
    }

    public String getEndApplyDate() {
        return endApplyDate;
    }

    public void setEndApplyDate(String endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    public String getStartAuditDate() {
        return startAuditDate;
    }

    public void setStartAuditDate(String startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    public String getEndAuditDate() {
        return endAuditDate;
    }

    public void setEndAuditDate(String endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    public String getStartStartTime() {
        return startStartTime;
    }

    public void setStartStartTime(String startStartTime) {
        this.startStartTime = startStartTime;
    }

    public String getEndStartTime() {
        return endStartTime;
    }

    public void setEndStartTime(String endStartTime) {
        this.endStartTime = endStartTime;
    }

    public String getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(String startEndTime) {
        this.startEndTime = startEndTime;
    }

    public String getEndEndTime() {
        return endEndTime;
    }

    public void setEndEndTime(String endEndTime) {
        this.endEndTime = endEndTime;
    }

    public int getStartProductCount() {
        return startProductCount;
    }

    public void setStartProductCount(int startProductCount) {
        this.startProductCount = startProductCount;
    }

    public int getEndProductCount() {
        return endProductCount;
    }

    public void setEndProductCount(int endProductCount) {
        this.endProductCount = endProductCount;
    }

    public int getStartStockCount() {
        return startStockCount;
    }

    public void setStartStockCount(int startStockCount) {
        this.startStockCount = startStockCount;
    }

    public int getEndStockCount() {
        return endStockCount;
    }

    public void setEndStockCount(int endStockCount) {
        this.endStockCount = endStockCount;
    }
}

package com.nineboy.seckill.vo;

import com.nineboy.seckill.model.ProductInfo;

import java.util.Date;

public class ProductInfoVO extends ProductInfo {
    private int startSeckillPrice;
    private int endSeckillPrice;

    private int startOriginalPrice;
    private int endOriginalPrice;

    private Date startApplyDate;
    private Date endApplyDate;

    private Date startAuditDate;
    private Date endAuditDate;

    private Date startStartTime;
    private Date endStartTime;

    private Date startEndTime;
    private Date endEndTime;

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

    public Date getStartApplyDate() {
        return startApplyDate;
    }

    public void setStartApplyDate(Date startApplyDate) {
        this.startApplyDate = startApplyDate;
    }

    public Date getEndApplyDate() {
        return endApplyDate;
    }

    public void setEndApplyDate(Date endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    public Date getStartAuditDate() {
        return startAuditDate;
    }

    public void setStartAuditDate(Date startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    public Date getEndAuditDate() {
        return endAuditDate;
    }

    public void setEndAuditDate(Date endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    public Date getStartStartTime() {
        return startStartTime;
    }

    public void setStartStartTime(Date startStartTime) {
        this.startStartTime = startStartTime;
    }

    public Date getEndStartTime() {
        return endStartTime;
    }

    public void setEndStartTime(Date endStartTime) {
        this.endStartTime = endStartTime;
    }

    public Date getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(Date startEndTime) {
        this.startEndTime = startEndTime;
    }

    public Date getEndEndTime() {
        return endEndTime;
    }

    public void setEndEndTime(Date endEndTime) {
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

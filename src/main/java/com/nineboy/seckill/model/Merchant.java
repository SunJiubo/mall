package com.nineboy.seckill.model;

/**
 * 商家实体
 */
public class Merchant {
    private int id;
    private String merchantName;
    private String merchantShopName;
    private String merchantAccount;
    private String merchantPassword;
    private String merchantScope;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantShopName() {
        return merchantShopName;
    }

    public void setMerchantShopName(String merchantShopName) {
        this.merchantShopName = merchantShopName;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getMerchantScope() {
        return merchantScope;
    }

    public void setMerchantScope(String merchantScope) {
        this.merchantScope = merchantScope;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", merchantName='" + merchantName + '\'' +
                ", merchantShopName='" + merchantShopName + '\'' +
                ", merchantAccount='" + merchantAccount + '\'' +
                ", merchantPassword='" + merchantPassword + '\'' +
                ", merchantScope='" + merchantScope + '\'' +
                '}';
    }
}

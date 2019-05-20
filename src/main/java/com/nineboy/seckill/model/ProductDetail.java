package com.nineboy.seckill.model;

public class ProductDetail {
    private int id;
    private int productId;//商品id
    private int merchantiId;//商家id
    private String productPlace;//商品产地
    private String productName;//商品名称
    private String brandName;//商品品牌
    private String productWeight;//商品重量
    private String specification;//规格包装
    private String productDetailPicture;//图片地址

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

    public int getMerchantiId() {
        return merchantiId;
    }

    public void setMerchantiId(int merchantiId) {
        this.merchantiId = merchantiId;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProductDetailPicture() {
        return productDetailPicture;
    }

    public void setProductDetailPicture(String productDetailPicture) {
        this.productDetailPicture = productDetailPicture;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", productId=" + productId +
                ", merchantiId=" + merchantiId +
                ", productPlace='" + productPlace + '\'' +
                ", productName='" + productName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", productWeight='" + productWeight + '\'' +
                ", specification='" + specification + '\'' +
                ", productDetailPicture='" + productDetailPicture + '\'' +
                '}';
    }
}

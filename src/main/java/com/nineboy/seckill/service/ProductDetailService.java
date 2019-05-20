package com.nineboy.seckill.service;

import com.nineboy.seckill.dao.ProductDetailDAO;
import com.nineboy.seckill.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailDAO productDetailDAO;

    public void insertProductDetail(ProductDetail productDetail){
        productDetailDAO.insertProductDetail(productDetail);
    }

    public ProductDetail queryProductDetailByProductId(int productId){
        return productDetailDAO.queryProductDetailByProductId(productId);
    }

    public void updateProductDetail(ProductDetail productDetail){
        productDetailDAO.updateProductDetail(productDetail);
    }


}

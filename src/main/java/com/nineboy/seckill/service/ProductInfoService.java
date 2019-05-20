package com.nineboy.seckill.service;

import com.nineboy.seckill.dao.ProductInfoDAO;
import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.vo.ProductInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductInfoService {
    @Autowired
    ProductInfoDAO productInfoDAO;

    public void applyProduct(ProductInfo productInfo){
        String starttime = productInfo.getStartTimeString();//
        String endtime = productInfo.getEndTimeString();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date starttimedate = dateformat.parse(starttime);
            productInfo.setStartTime(starttimedate);
            Date endtimedate = dateformat.parse(endtime);
            productInfo.setEndTime(endtimedate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        productInfo.setAuditDate(new Date());
        productInfo.setAuditState(1);
        productInfoDAO.applyProduct(productInfo);
    }


    public ProductInfo queryProductInfoById(int id){
        return productInfoDAO.queryProductInfoById(id);
    }

    public List<ProductInfo> listProduct(ProductInfoVO productInfoVO){
        return productInfoDAO.listProduct(productInfoVO);
    }

    public void updateProductState(int id, int state){
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productInfoVO.setId(id);
        productInfoVO.setAuditState(state);
        productInfoDAO.updateProductState(productInfoVO);
    }

    public void updateProductInfo(ProductInfo productInfo){
        String starttime = productInfo.getStartTimeString();//
        String endtime = productInfo.getEndTimeString();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date starttimedate = dateformat.parse(starttime);
            productInfo.setStartTime(starttimedate);
            Date endtimedate = dateformat.parse(endtime);
            productInfo.setEndTime(endtimedate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        productInfoDAO.updateProductInfo(productInfo);
    }

    public void deleteProductInfoById(int id){
        productInfoDAO.deleteProductInfoById(id);
    }


}

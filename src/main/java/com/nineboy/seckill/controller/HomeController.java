package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.ProductDetail;
import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.service.ProductDetailService;
import com.nineboy.seckill.service.ProductInfoService;
import com.nineboy.seckill.vo.ProductInfoVO;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/homepage")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductDetailService productDetailService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String home(Model model){
        ProductInfoVO productInfoVO = new ProductInfoVO();
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowString = dateFormat.format(now);
        productInfoVO.setStartEndTime("2019-05-23");
        productInfoVO.setAuditState(2);
        List<ProductInfo> list = productInfoService.listProduct(productInfoVO);
        model.addAttribute("list",list);
        return "homepage/home";
    }

    @RequestMapping(path = "/viewproductdetail",method = RequestMethod.GET)
    public String viewProductDetail(Model model,
                                    @Param("id") int id){
        ProductInfo productInfo = productInfoService.queryProductInfoById(id);
        ProductDetail productDetail = productDetailService.queryProductDetailByProductId(id);
        model.addAttribute("productInfo",productInfo);
        model.addAttribute("productDetail",productDetail);
        return "order/selldetail";
    }
}

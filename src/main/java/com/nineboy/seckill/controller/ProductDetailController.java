package com.nineboy.seckill.controller;

import com.nineboy.seckill.model.ProductDetail;
import com.nineboy.seckill.service.ProductDetailService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path ={"/productdetail"} )
public class ProductDetailController {
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailController.class);

    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping(path = {"/toinsertproductdetail"}, method = {RequestMethod.GET})
    public String toInsertProductDetail(Model model,
                                        @RequestParam("productId") int productId,
                                        @RequestParam("merchantId") int merchantId) {
        model.addAttribute("productId",productId);
        model.addAttribute("merchantId",merchantId);
        return "productdetail/insertproductdetail";
    }

    @RequestMapping(path ={"/insertproductdetail"},method = {RequestMethod.GET,RequestMethod.POST})
    public String insertProductDetail(ProductDetail productDetail){
        productDetailService.insertProductDetail(productDetail);
        System.out.println(productDetail);
        return "redirect:/productinfo/listproduct";
    }

    @RequestMapping(path = {"/toupdateproductdetail"}, method = {RequestMethod.GET})
    public String toUpdateProductDetail(Model model,
                           @RequestParam("productId") int productId) {
        ProductDetail productDetail = productDetailService.queryProductDetailByProductId(productId);
        System.out.println(productDetail);
        model.addAttribute("productDetail",productDetail);
        return "productdetail/updateproductdetail";
    }

    @RequestMapping(path = {"/updateproductdetail"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String updateProductDetail(Model model,ProductDetail productDetail) {
        productDetailService.updateProductDetail(productDetail);
        System.out.println(productDetail);
        return "redirect:/productinfo/listproduct";
    }

    @RequestMapping(path = {"/queryproductdetailbyid"}, method = {RequestMethod.GET})
    public String queryProductDetailById(Model model,
                            @RequestParam("productId") int productId) {
        ProductDetail productDetail = productDetailService.queryProductDetailByProductId(productId);
        System.out.println(productDetail);
        model.addAttribute("productDetail",productDetail);
        return "productdetail/productdetailview";
    }


}

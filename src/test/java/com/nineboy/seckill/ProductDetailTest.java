package com.nineboy.seckill;

import com.nineboy.seckill.model.ProductDetail;
import com.nineboy.seckill.service.ProductDetailService;
import com.nineboy.seckill.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductDetailTest {

    @Autowired
    ProductDetailService productDetailService;
    @Test
    public void test() {
        ProductDetail p = new ProductDetail();
        p.setBrandName("nike");
        p.setMerchantiId(1);
        p.setProductId(001);
        p.setProductName("詹姆斯16");
        p.setProductDetailPicture("www.baidu.com");
        p.setProductPlace("泰国");
        p.setProductWeight("300g");
        p.setSpecification("1双");
//        productDetailService.insertProductDetail(p);
//        System.out.println(productDetailService.queryProductDetailById(1));
        p.setId(1);
        p.setProductWeight("300g");
        productDetailService.updateProductDetail(p);
    }
}

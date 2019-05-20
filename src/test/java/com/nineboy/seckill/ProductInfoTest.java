package com.nineboy.seckill;

import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.ProductInfoService;
import com.nineboy.seckill.service.UserService;
import com.nineboy.seckill.vo.ProductInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductInfoTest {

    @Autowired
    ProductInfoService productInfoService;
    @Test
    public void test() {
//        ProductInfo productInfo = new ProductInfo(1,"1","1",1,1,1,new Date(),new Date(),1,new Date(),new Date(),1,1,"1");
//        productInfoService.applyProduct(productInfo);
//        productInfoService.deleteProductInfoById(1);

//        ProductInfo productInfo = productInfoService.queryProductInfoById(2);
//        productInfo.setProductId(3);
//        productInfoService.updateProductInfo(productInfo);
//        System.out.println(productInfo);
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//        productInfoVO.setStartSeckillPrice(200);
//        List<ProductInfo> list = productInfoService.listProduct(productInfoVO);
//        for (ProductInfo pro :
//                list) {
//            System.out.println(pro);
//        }
        productInfoService.updateProductState(5,2);
    }
}

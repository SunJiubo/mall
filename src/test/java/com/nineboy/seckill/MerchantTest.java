package com.nineboy.seckill;

import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.service.MerchantService;
import com.nineboy.seckill.vo.MerchantVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MerchantTest {


    @Autowired
    MerchantService merchantService;

    @Test
    public void test() {
//        Merchant merchant = merchantService.queryMerchantById(3);
//        System.out.println(merchant);
//        Merchant merchant1 = new Merchant();
//        merchant1.setId(3);
//        merchant1.setMerchantAccount("www");
//        merchant1.setMerchantName("www");
//        merchant1.setMerchantPassword("www");
//        merchant1.setMerchantScope("www");
//        merchant1.setMerchantShopName("www");
//        merchantService.insertMerchant(merchant1);
//        merchantService.updateMerchant(merchant1);
//        merchantService.deleteMerchantById(1);
        MerchantVO merchantVO = new MerchantVO();
//        merchantVO.setMerchantName("qqq");
        merchantVO.setMerchantShopName("阿迪达斯");
        List<Merchant> list = merchantService.queryMerchantByVo(merchantVO);
        for(Merchant merchant:list){
            System.out.println(merchant);
        }

    }
}


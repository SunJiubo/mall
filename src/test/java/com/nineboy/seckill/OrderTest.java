package com.nineboy.seckill;

import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.OrderService;
import com.nineboy.seckill.service.UserService;
import com.nineboy.seckill.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    OrderService orderService;
    @Test
    public void test() {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(1);
        orderVO.setPayType(2);
        orderVO.setPayStatus(2);
        orderService.updateOrderPaystatusById(2,1,2);
    }
}

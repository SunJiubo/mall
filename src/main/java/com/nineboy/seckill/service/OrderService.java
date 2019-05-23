package com.nineboy.seckill.service;

import com.nineboy.seckill.dao.OrderDAO;
import com.nineboy.seckill.dao.ProductDetailDAO;
import com.nineboy.seckill.model.Order;
import com.nineboy.seckill.model.ProductDetail;
import com.nineboy.seckill.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    public void insertOrder(Order order){
        orderDAO.insertOrder(order);
    }

    public List<Order> queryOrderByUserId(int userId){
        return orderDAO.queryOrderByUserId(userId);
    }

    public List<Order> queryOrderByMerchantId(int MerchantId){
        return orderDAO.queryOrderByMerchantId(MerchantId);
    }

    public void updateOrderPaystatusById(int payStatus,int id, int payType){
        OrderVO orderVO = new OrderVO();
        orderVO.setId(id);
        orderVO.setPayStatus(payStatus);
        orderVO.setPayType(payType);
        orderDAO.updateOrderPaystatusById(orderVO);
    }


}

package com.nineboy.seckill.dao;

import com.nineboy.seckill.model.Order;
import com.nineboy.seckill.model.ProductDetail;
import com.nineboy.seckill.vo.OrderVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderDAO {
    // 注意空格
    String TABLE_NAME = " seckill.sk_order ";
    String INSERT_FIELDS = " product_id, pay_amount, user_id, merchant_id, create_time , pay_status, receiver_address, receiver_phone, receiver_name, tradeserial_number,num,pay_type";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{productId},#{payAmount},#{userId},#{merchantId},#{createTime},#{payStatus},#{receiverAddress},#{receiverPhone},#{receiverName},#{tradeserialNumber},#{num})"})
    public void insertOrder(Order order);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where user_id=#{userId}"})
    public List<Order> queryOrderByUserId(int userId);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where merchant_id=#{MerchantId}"})
    public List<Order> queryOrderByMerchantId(int MerchantId);


    @Update({"update ",TABLE_NAME,
            " set pay_status=#{payStatus}, pay_type=#{payType} where id = #{id}"})
    public void updateOrderPaystatusById(OrderVO orderVO);

//    @Update({"update ",TABLE_NAME,
//            " set product_place=#{productPlace}, product_name=#{productName}, brand_name=#{brandName}, product_weight=#{productWeight}, specification=#{specification}, product_detail_picture=#{productDetailPicture} where id = #{id}"})
//    public void updateProductDetail(ProductDetail productDetail);

}

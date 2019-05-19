package com.nineboy.seckill.dao;

import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.vo.ProductInfoVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProductInfoDAO {
    // 注意空格
    String TABLE_NAME = " seckill.skproduct_info ";
    String INSERT_FIELDS = " product_id, product_title, product_picture, seckill_price, original_price , merchant_id, apply_date, audit_date, audit_state,start_time,end_time,product_count,stock_count,description ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{productId},#{productTitle},#{productPicture},#{seckillPrice},#{originalPrice},#{merchantId},#{applyDate},#{auditDate},#{auditState},#{startTime},#{endTime},#{productCount},#{stockCount},#{description})"})
    public void applyProduct(ProductInfo productInfo);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where id=#{id}"})
    public ProductInfo queryProductInfoById(int id);

    public List<ProductInfo> listProduct(@Param("productInfoVO") ProductInfoVO productInfoVO);


    @Update({"update ",TABLE_NAME,
            " set product_id=#{productId}, product_title=#{productTitle}, product_picture=#{productPicture}, seckill_price=#{seckillPrice}, original_price=#{originalPrice}, merchant_id=#{merchantId}, apply_date=#{applyDate},audit_date=#{auditDate}, audit_state=#{auditState}, start_time=#{startTime}, end_time=#{endTime}, product_count=#{productCount}, stock_count=#{stockCount}, description=#{description} where id = #{id}"})
    public void updateProductInfo(ProductInfo productInfo);

    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    public void deleteProductInfoById(int id);
}

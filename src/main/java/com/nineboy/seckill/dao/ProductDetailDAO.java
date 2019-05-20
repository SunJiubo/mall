package com.nineboy.seckill.dao;

import com.nineboy.seckill.model.ProductDetail;
import com.nineboy.seckill.model.ProductInfo;
import com.nineboy.seckill.vo.ProductInfoVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProductDetailDAO {
    // 注意空格
    String TABLE_NAME = " seckill.skproduct_detail ";
    String INSERT_FIELDS = " product_id, merchant_id, product_place, product_name, brand_name , product_weight, specification, product_detail_picture";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{productId},#{merchantiId},#{productPlace},#{productName},#{brandName},#{productWeight},#{specification},#{productDetailPicture})"})
    public void insertProductDetail(ProductDetail productDetail);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where id=#{id}"})
    public ProductDetail queryProductDetailById(int id);

    @Update({"update ",TABLE_NAME,
            " set product_place=#{productPlace}, product_name=#{productName}, brand_name=#{brandName}, product_weight=#{productWeight}, specification=#{specification}, product_detail_picture=#{productDetailPicture} where id = #{id}"})
    public void updateProductDetail(ProductDetail productDetail);

}

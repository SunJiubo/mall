package com.nineboy.seckill.dao;

import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.vo.MerchantVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MerchantDAO {

    String TABLE_NAME = " seckill.sk_merchant ";
    String INSERT_FIELDS = " merchant_name, merchant_shopname, merchant_account, merchant_password, merchant_scope ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    public void insertMerchant(@Param("merchant") Merchant merchant);

    @Select({"select ",SELECT_FIELDS, " from ", TABLE_NAME,
            " where id=#{id}"})
    public Merchant queryMerchantById(int id);

    public List<Merchant> queryMerchantByVo(@Param("merchantVO") MerchantVO merchantVO);

    @Update({"update ",TABLE_NAME,
            " set merchant_name=#{merchantName}, merchant_shopname=#{merchantShopName}, merchant_account=#{merchantAccount}, merchant_password=#{merchantPassword}, merchant_scope=#{merchantScope} where id = #{id}"})
    public void updateMerchant(Merchant merchant);

    @Delete({"delete from " ,TABLE_NAME," where id = #{id}"})
    public void deleteMerchantById(int id);
}


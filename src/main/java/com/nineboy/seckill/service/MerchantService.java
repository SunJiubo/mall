package com.nineboy.seckill.service;

import com.nineboy.seckill.dao.MerchantDAO;
import com.nineboy.seckill.model.Merchant;
import com.nineboy.seckill.vo.MerchantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {
    @Autowired
    MerchantDAO merchantDAO;

    public void insertMerchant(Merchant merchant){
        merchantDAO.insertMerchant(merchant);
    }


    public Merchant queryMerchantById(int id){
        return merchantDAO.queryMerchantById(id);

    }

    public Merchant queryMerchantByAccount(String merchantAccount){
        return merchantDAO.queryMerchantByAccount(merchantAccount);
    }

    public List<Merchant> queryMerchantByVo(MerchantVO merchantVO){
        return merchantDAO.queryMerchantByVo(merchantVO);
    }

    public void updateMerchant(Merchant merchant){
        merchantDAO.updateMerchant(merchant);
    }

    public void deleteMerchantById(int id){
        merchantDAO.deleteMerchantById(id);
    }
}

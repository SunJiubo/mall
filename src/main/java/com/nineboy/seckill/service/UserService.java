package com.nineboy.seckill.service;

import com.nineboy.seckill.dao.UserDAO;
import com.nineboy.seckill.model.User;
import com.nineboy.seckill.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public void insertUser(User user){
        userDAO.insertUser(user);
    }

    public User queryUserById(int id){
        return userDAO.queryUserById(id);
    }

    public List<User> queryUserByVo(UserVO userVO){
        return userDAO.queryUserByVo(userVO);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public void deleteUserById(int id){
        userDAO.deleteUserById(id);
    }
}

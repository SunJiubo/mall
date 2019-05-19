package com.nineboy.seckill;

import com.nineboy.seckill.model.User;
import com.nineboy.seckill.service.UserService;
import com.nineboy.seckill.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;
    @Test
    public void test() {
        User user = new User();
        user.setName("wan");
        user.setPassword("wan");
        user.setAddress("wan");
        user.setAge(15);
        user.setAccount("wan");
        user.setEmail("940755052@qq.com");
        user.setSex(2);
//        userService.insertUser(user);
//        User user1 = userService.queryUserById(2);
//        System.out.println(user1);
//        UserVO userVO = new UserVO();
//        userVO.setName("wan");
//        List<User> list = userService.queryUserByVo(userVO);
//        for (User u:
//                list) {
//            System.out.println(u);
//        }
        userService.deleteUserById(7);
    }
}

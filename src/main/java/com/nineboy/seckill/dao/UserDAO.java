package com.nineboy.seckill.dao;

import com.nineboy.seckill.model.User;
import com.nineboy.seckill.vo.UserVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Component
@Mapper
public interface UserDAO {
    // 注意空格
    String TABLE_NAME = " seckill.sk_user ";
    String INSERT_FIELDS = " name, account, password, sex, age, address, email ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{account},#{password},#{sex},#{age},#{address},#{email})"})
    public void insertUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where id=#{id}"})
    public User queryUserById(int id);

    public List<User> queryUserByVo(@Param("userVO") UserVO userVO);


    @Update({"update ",TABLE_NAME,
            " set name=#{name}, account=#{account}, password=#{password}, sex=#{sex}, age=#{age}, address=#{address}, email=#{email} where id = #{id}"})
    public void updateUser(User user);

    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    public void deleteUserById(int id);
}

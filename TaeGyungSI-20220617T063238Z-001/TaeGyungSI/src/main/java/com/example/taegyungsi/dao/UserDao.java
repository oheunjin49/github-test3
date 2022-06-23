package com.example.taegyungsi.dao;

import com.example.taegyungsi.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
//    id로 유저 가져오기 메소드
    User findById(String id);

//    name으로 유저 가져오기 메소드
    User findByName(String name);

//    회원정보(user) insert메소드
    int insertUser(User user);

//    회원정보(user) delete 메소드
    int deleteUser(String name);
}

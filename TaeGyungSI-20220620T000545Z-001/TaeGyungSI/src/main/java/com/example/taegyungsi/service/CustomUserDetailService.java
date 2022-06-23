package com.example.taegyungsi.service;

import com.example.taegyungsi.dao.UserDao;
import com.example.taegyungsi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//유저의 정보를 얻기위한 서비스(id, 이름, 이메일, 패스워드)

//@Service : springboot에 객체로 생성
@Service

public class CustomUserDetailService implements UserDetailsService {


    @Autowired
    UserDao userDao; // 객체 정의 (NULL => 스프링객체 받기)

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userDao.findById(id);
    }

    public UserDetails findByName(String name){
        return userDao.findByName(name);
    }

//    유저가 null이면 insert하고(유저생성성), 아니면 -1 반환하는 소드
    public int signInUser(User user){
        if(userDao.findByName(user.getUsername())==null){
            return userDao.insertUser(user);
        }else{
            return -1;
        }
    }
}

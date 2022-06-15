package com.example.dongsungsi.dao;

import com.example.dongsungsi.model.Complain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ComplainDao {
//    화면에서 모든 목록 조회
    List<Complain> findAll();
    int insertComplain(Complain complain);

    int updateComplain(Complain complain);

    int deleteAll();


}

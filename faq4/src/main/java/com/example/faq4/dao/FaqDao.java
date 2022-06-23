package com.example.faq4.dao;

import com.example.faq4.model.Faq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqDao {

    List<Faq> findAll(); // 모든 모록

    int registerFaq(Faq faq); // 등록

    int deleteFaq(int no); // 삭제

    int updateFaq(Faq faq); //수정

}








package com.example.faq.dao;

import com.example.faq.model.Faq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqDao {

    List<Faq> findAll();

    int registerFaq(Faq faq);

    int updateFaq(Faq faq);

    int deleteFaq(Long no);
}

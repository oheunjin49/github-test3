package com.example.faq4.service;

import com.example.faq4.model.Faq;

import java.util.List;

public interface FaqService {

    List<Faq> findAll(); // 모든 모록

   boolean save(Faq faq);

    boolean deleteFaq(int no); // 삭제

}

package com.example.faq.Service;

import com.example.faq.model.Faq;

import java.util.List;

public interface FaqService {

    List<Faq> findAll();

    boolean save(Faq faq);


    boolean deleteFaq(Long no);
}

package com.example.faq4.service;

import com.example.faq4.dao.FaqDao;
import com.example.faq4.model.Faq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqServiceImpl implements FaqService{

    @Autowired
    private FaqDao faqDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Faq> findAll() {
        return faqDao.findAll();
    }

    @Override
    public boolean save(Faq faq) {
        int queryResult = 0;

        logger.info("faq {}", faq);

        if (faq.getNo() == null) {
            logger.info("gaq.getNo() {}", faq.getNO());
            queryResult = faqDao.registerFaq(faq);
            logger.info("queryResult {}", queryResult);
        } else {
            queryResult = faqDao.updateFaq(faq);
        }

        return (queryResult >= 1) ? true : false;
    }


    @Override
    public boolean deleteFaq(int no) {
        int queryResult = 0;

//        delete / update / insert 문은 결과 실행 후
//        정상 실행되면 건수(삭제/수정/생성)가 결과로 리턴(반환)
        queryResult = faqDao.deleteFaq(no);

        return (queryResult >=1) ? true : false;
    }



}

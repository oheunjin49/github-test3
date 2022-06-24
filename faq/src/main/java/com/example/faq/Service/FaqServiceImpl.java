package com.example.faq.Service;

import com.example.faq.dao.FaqDao;
import com.example.faq.model.Faq;
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

        logger.info("faq {}",faq);

        if(faq.getNo()==null){
            queryResult = faqDao.registerFaq(faq);
        } else {
            queryResult =faqDao.updateFaq(faq);
        }
        return (queryResult >= 1) ? true : false ;
    }

    @Override
    public boolean deleteFaq(Long no) {
        int queryResult = 0;
         queryResult = faqDao.deleteFaq(no);
        return (queryResult >= 1)? true :false;
    }
}

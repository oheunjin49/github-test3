package com.example.dongsungsi.service;

import com.example.dongsungsi.dao.ComplainDao;
import com.example.dongsungsi.model.Complain;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainDao complainDao;

    @Override
    public List<Complain> findAll() {
        return complainDao.findAll();
    }

    @Override
    public boolean save(Complain complain) {
        int queryResult = 0;


        if(complain.getTitle() == null) {
//            id 값이 없으면 insert 문 실행
            queryResult = complainDao.insertComplain(complain);
        } else {
//            id 값이 있으면 update 문 실행
            queryResult = complainDao.updateComplain(complain);
        }

        return (queryResult >= 1) ? true : false;
    }


    @Override
    public boolean deleteAll() {
        int queryResult = 0;

//        delete / update / insert 문은 결과 실행 후
//        정상 실행되면 건수(삭제/수정/생성)가 결과로 리턴(반환)
        queryResult = complainDao.deleteAll();

        return (queryResult >= 1) ? true : false;

    }
}

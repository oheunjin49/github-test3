package com.example.dongsungsi.service;

import com.example.dongsungsi.dao.CustomerDao;
import com.example.dongsungsi.model.Customer;
import com.example.dongsungsi.paging.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.customerspring.service
 * fileName : CustomerServiceImpl
 * author : ds
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-07         ds          최초 생성
 */
// @Service : 스프링에 객체로 생성
@Service
public class CustomerServiceImpl implements CustomerService {

//    스프링에 customerDao 이미 생성되어 있음
//    생성된 객체를 받아오는 어노테이션 : @Autowired
    @Autowired
    private CustomerDao customerDao; // 객체 정의 ( null => 스프링 객체 )

//    나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());

//    id로 회원 조회 하는 메소드
    @Override
    public Optional<Customer> findById(long id) {
        return customerDao.findById(id);
    }

//    Todo : 1개 수정 findAll, 1개 추가 findByEmailContaining
//    모든 회원 조회 서비스
    @Override
    public List<Customer> findAll(Criteria criteria) {

        return customerDao.findAll(criteria);
    }

    @Override
    public List<Customer> findByEmailContaining(Criteria criteria) {
//        emptyList : List 빈 객체 초기화
        List<Customer> customers = Collections.emptyList();

//        null 체크 : email 이 null 인지 아닌지 체크
        Optional<String> optionalCriteria
                = Optional.ofNullable(criteria.getEmail());

//        테이블의 총 건수를 조회하는 메소드 호출
//        email이 null이면 -> "" 바뀜
        int totalCount
            = customerDao.selectTotalCount(optionalCriteria.orElse(""));
        
//        Criteria 객체의 변수에 저장 : 페이지정보(totalCount, totalPages)
        criteria.setTotalItems(totalCount); // 테이블 총 건수 저장

//        totalPages(총페이지수) = totalCount(총건수) / size(1페이지당 총 건수)
        criteria.setTotalPages(totalCount / criteria.getSize());

        if(criteria.getEmail() == null) {
//            email 없으면 전체검색(여러건 -> List)
            customers = customerDao.findAll(criteria);

        } else {
//            email 있으면 email 검색(여러건 -> List)
            customers = customerDao.findByEmailContaining(criteria);
        }

        return customers;
    }

    //    회원 생성 / 수정 서비스 ( insert / update )
    @Override
    public Optional<Customer> save(Customer customer) {
//        db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

//        매개변수 customer 정보 출력
        logger.info("customer {}", customer);

//        customer.getId() 없으면 insert 문 호출( 새로운 회원 생성 )
        if(customer.getId() == null) {
            customerDao.insertCustomer(customer);
        }
        //                         있으면 update 문 호출
        else {
            customerDao.updateCustomer(customer);
        }

//        insert 문 후에는 customer의 id속성에 값이 저장됨(<selectkey>)
        seqId = customer.getId();
        logger.info("seqId {}", seqId);

        return customerDao.findById(seqId);
    }

    @Override
    public boolean deleteById(Long id) {
        int queryResult = 0;

        queryResult = customerDao.deleteCustomer(id);

        return (queryResult >=1) ? true : false;
    }

    @Override
    public boolean deleteAll() {
        int queryResult = 0;

//        delete / update / insert 문은 결과 실행 후
//        정상 실행되면 건수(삭제/수정/생성)가 결과로 리턴(반환)
        queryResult = customerDao.deleteAll();

        return (queryResult >=1) ? true : false;
    }
}












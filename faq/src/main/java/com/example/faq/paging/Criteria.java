package com.example.faq.paging;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.dongsungsi.paging
 * fileName : Criteria
 * author : ds
 * date : 2022-06-13
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-13         ds          최초 생성
 */
@Setter
@Getter
@ToString
public class Criteria {

//    현재 페이지 번호
    private Integer page;

//    페이지당 출력할 데이터 개수(건수)
    private Integer size;

//    Todo: 아래 1개 추가( Customer Vue 검색용으로 사용 )
    private String email;

    private String title; // ( Tutorial Vue 검색용으로 사용 )

//    테이블 총 건수
    private Integer totalItems;

//    총 페이지 개수 = 테이블 총 건수(totalItems) / 페이지당 출력할 데이터 개수(size)
    private Integer totalPages;

//    기본 생성자 ( 페이지 데이터 초기화 )
    public Criteria() {
        this.page = 0; // 기본 현재페이지 : 0
        this.size = 3; // 기본 1페이지당 개수 : 3
    }
}











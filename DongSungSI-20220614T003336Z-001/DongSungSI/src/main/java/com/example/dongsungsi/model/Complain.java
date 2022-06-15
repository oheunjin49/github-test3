package com.example.dongsungsi.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Complain {
    private int no;
    private String title;
    private String content;
    private String target_page;
    private String writer;
    private String deleteYn;
    private String insertTime;
    private String updateTime; // 수정날짜
    private String deleteTime; // 삭제날짜

}

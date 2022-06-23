package com.example.taegyungsi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MessageResponse {
    private String message;

//    생성자
    public MessageResponse(String message) {
        this.message = message;
    }
}

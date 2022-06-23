package com.example.taegyungsi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class JwtResponse {

    private String token; //웹 토큰
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> roles; // 역할 (ROLE_ADMIN, ROLE_USER 등등)

//    TYPE을 제외한 모든 매개변수가 있는 생성자 정의
    public JwtResponse(String token, String id, String username, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}

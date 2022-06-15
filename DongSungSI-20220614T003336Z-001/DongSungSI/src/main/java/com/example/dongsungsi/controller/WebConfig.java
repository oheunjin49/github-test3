package com.example.dongsungsi.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration : 환경 설정파일
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @CrossOrigin 어노테이션과 동일함
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        addMapping : springboot 서버로 들어오는 모든 요청
        registry.addMapping("/**")
//                아래 주소로 들어오는 요청은 보안 허용
                .allowedOrigins("http://localhost:8080");
    }
}

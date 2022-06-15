package com.example.dongsungsi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class RootController implements ErrorController {

//    에러가 (Not Found) 발생하면 강제적으로 index.html 주소로 변경 (redirect)
    @GetMapping("/error")
    public String redirectRoot(){
        return "index.html";
    }
}

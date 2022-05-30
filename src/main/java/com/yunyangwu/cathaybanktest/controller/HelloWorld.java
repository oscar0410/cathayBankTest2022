package com.yunyangwu.cathaybanktest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorld {

    @GetMapping("/hello")
    public String test(){
        String rtnStr = "Hello World!";
        System.out.println(rtnStr);
        return rtnStr;
    }
}

package com.fq.luckymoney.controller;

import com.fq.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunTest {
    @Autowired
    private LimitConfig limitConfig;
    @GetMapping(value = {"/hello","/"})
    public String hello(){
        return "desc:"+limitConfig.getDescription();
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}

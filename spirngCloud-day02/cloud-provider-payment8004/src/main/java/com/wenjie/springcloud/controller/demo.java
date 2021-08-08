package com.wenjie.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@ResponseBody
public class demo {

    @Value("${spring.application.name}")
    String host ;


    @GetMapping("/take")
    public String getconnection(){
        String string = UUID.randomUUID().toString();
        return host+"success"+string;
    }
}

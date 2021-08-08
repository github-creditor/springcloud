package com.wenjie.springcloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@ResponseBody
public class demo {

    @Autowired
    RestTemplate restTemplate;

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @GetMapping("/demo")
    public String demo(){
        String forObject = restTemplate.getForObject(INVOKE_URL + "/take", String.class);
        return forObject;
    }
}

package com.wenjie.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wenjie.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentHystrixController {

    @Autowired
   private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){

        return paymentHystrixService.paymentInfo_ok(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_BackMethod",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/consumer/payment/htstrix/timesout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo__TimeOut(id);
    }

    public String paymentInfo_TimeOut_BackMethod(/*@PathVariable("id") */Integer id){
        return "消费者出错了！！！";
    }

}

package com.wenjie.springcloud.controller;

import com.wenjie.springcloud.entities.CommonResult;
import com.wenjie.springcloud.entities.Payment;
import com.wenjie.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

}

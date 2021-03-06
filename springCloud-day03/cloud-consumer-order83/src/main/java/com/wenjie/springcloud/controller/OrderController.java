package com.wenjie.springcloud.controller;

import com.wenjie.springcloud.entities.CommonResult;
import com.wenjie.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

//    public static  final  String PAYMENT_URL="http://localhost:8001";
    public static  final  String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
//                                              请求的路径                   请求参数        请求返回值
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")

    public CommonResult<Payment> getPayment(@PathVariable("id") long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }


}

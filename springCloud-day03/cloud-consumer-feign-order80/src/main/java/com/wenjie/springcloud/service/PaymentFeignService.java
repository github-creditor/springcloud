package com.wenjie.springcloud.service;

import com.wenjie.springcloud.entities.CommonResult;
import com.wenjie.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//      表示你要连接到的服务器的名称是什么
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

//    这个value的值指向的是服务器端对应的路径值
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);



}

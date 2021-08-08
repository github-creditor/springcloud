package com.wenjie.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "全局配置服务降级处理，服务出错";
    }

    @Override
    public String paymentInfo__TimeOut(Integer id) {
        return "全局配置服务降级处理，服务出错，超时设置";
    }
}

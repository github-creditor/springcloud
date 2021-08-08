package com.wenjie.springcloud.service;

import com.wenjie.springcloud.entities.Payment;
import com.wenjie.springcloud.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class PaymentServiceImp implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}

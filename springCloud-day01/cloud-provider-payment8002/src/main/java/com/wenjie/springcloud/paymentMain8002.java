package com.wenjie.springcloud;


import com.wenjie.springcloud.service.PaymentServiceImp;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.wenjie.springcloud.mapper")
@EnableEurekaClient
@SpringBootApplication
public class paymentMain8002 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(paymentMain8002.class, args);
        run.getBean(PaymentServiceImp.class);
    }
}

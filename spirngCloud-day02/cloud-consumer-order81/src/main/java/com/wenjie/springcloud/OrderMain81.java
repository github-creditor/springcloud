package com.wenjie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class, args);
    }
}

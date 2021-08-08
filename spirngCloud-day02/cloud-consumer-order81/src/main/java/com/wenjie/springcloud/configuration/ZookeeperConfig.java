package com.wenjie.springcloud.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZookeeperConfig {

    @Bean
    @LoadBalanced   //这个注解一定要加，要不然的话没有办法使用负载均衡。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

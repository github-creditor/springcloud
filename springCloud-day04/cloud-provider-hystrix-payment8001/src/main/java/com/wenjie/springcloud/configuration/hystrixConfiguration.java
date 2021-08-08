package com.wenjie.springcloud.configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class hystrixConfiguration {
//    springcloud的一个监控出现的问题，需要自己进行配置
//
//      此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
//      ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
//      只要在自己的项目里配置上下面的servlet就可以了
//      否则，Unable to connect to Command Metric Stream 404


    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}

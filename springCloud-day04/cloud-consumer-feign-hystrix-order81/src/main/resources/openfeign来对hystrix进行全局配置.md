# 使用openfeign来对hystrix进行配置

## 1.在application中进行开启openfeign的支持
```yaml
feign:  
	hystrix:    enabled: true #开启feign对hystrix的服务降级处理
```
## 2.在主配置类上添加注解
```java
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain81.class, args);
    }
}
```
## 3.进行设置
```java
@Component
//          这个是feign的方法，第一个主要的目的就是进行服务调用        第二个主要是进行服务的降级处理
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/htstrix/timesout/{id}")
    public String paymentInfo__TimeOut(@PathVariable("id") Integer id);
}
```
```java
// 需要这个方法基础前面的接口，然后对接口进行重写，最后如果发生异常的话，就会进行服务的降级。
// 这样的主要好处就是可以对服务降级进行集中的管理，可以方便后期的维护
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
```




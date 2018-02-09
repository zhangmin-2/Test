package com.zm.spring.cloud.pptest_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableCaching
@EnableFeignClients
/**
 * EnableCircuitBreaker表示开启断路器
 * @SpringBootApplication 表示是启动类
 * @EnableDiscoveryClient 表示服务发现
 * 我们也可以使用SpringCloudApplication代替上面的三个注解
 * @EnableFeignClients 表示开启fegin
 * 
 * 
 * @author yp-tc-m-7129
 *
 */
public class RibbonConsumerApplication {
	
	   public static void main(String[] args) {
	        SpringApplication.run(RibbonConsumerApplication.class, args);
	    }
	 
	    /**
	     * 为了可以负载均衡的使用RestTemplate，让controller表可以直接使用注入的RestTemplate
	     * @return
	     */
	    @LoadBalanced
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	    
	    /**
	     * 为了可以使用断路器,
	     * @return
	     */
	    @Bean
	    public HystrixCommandAspect hystrixCommandAspect() {
	        return new HystrixCommandAspect();
	    }
}

package com.zm.spring.cloud.pptest_consumer.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zm.provider.entity.Book;

/**
 * 使用feign避免使用restTemplate的统一模板方式
 * @author yp-tc-m-7129
 *
 */
@FeignClient("HELLO-SERVICE")
public interface HelloFeignClient {

	@RequestMapping("/hello")
    String hello();
	
	@RequestMapping("/sayNameAndAge")
    String sayNameAndAge(@RequestParam(value ="name") String name,@RequestParam(value ="age") String age);
	
	@RequestMapping(value = "/getBook",method = RequestMethod.GET)
	Book getBook(@RequestBody Book book);
	
	@RequestMapping(value = "/getBook2")
	Book getBook2(@RequestBody Book book);
}

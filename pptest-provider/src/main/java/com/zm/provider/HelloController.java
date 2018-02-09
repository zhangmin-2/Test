package com.zm.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zm.provider.entity.Book;

@RestController
public class HelloController {
    
	private final Logger logger = Logger.getLogger(HelloController.class);
    
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        List<ServiceInstance> instances = client.getInstances("hello-service");
        for (int i = 0; i < instances.size(); i++) {
            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "Hello World";
    }
   
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(String name) {
    	return "您好"+name;
    }
    
    @RequestMapping(value = "/sayNameAndAge", method = RequestMethod.GET)
    public String sayNameAndAge(String name,String age) {
    	logger.info("----- HelloController sayNameAndAge 进入 name= "+name + "age="+ age);
    	return "您好"+name + "您今年"+age +"岁了!";
    }
    
    @RequestMapping(value = "/sayNameAndAge2", method = RequestMethod.POST)
    public String sayNameAndAge2(@RequestBody Map<String, String> map) {
    	logger.info("----- HelloController sayNameAndAge2 进入");
    	return "您好"+map.get("name") + "您今年"+map.get("age") +"岁了!";
    }
    
    @RequestMapping(value = "/sayBook", method = RequestMethod.GET)
    public Book sayBook() {
    	logger.info("----- HelloController sayBook");
        return new Book("三国演义", 90, new Date());
    }
    
    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
    public Book getBook(@RequestBody Book book) {
    	logger.info("----- HelloController getBook, book=" + JSONObject.toJSONString(book));
    	book.setName("哈哈你过来了");
        return book;
    }
    
    @RequestMapping(value = "/getBook2")
    public Book getBook2(@RequestBody Book book) {
    	logger.info("----- HelloController getBook2, book=" + JSONObject.toJSONString(book));
    	book.setName("说谎");
        return book;
    }
    
    
}
package com.zm.spring.cloud.pptest_consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zm.provider.entity.Book;

@RestController
public class ConsumerController {
	
	private final Logger logger = Logger.getLogger(ConsumerController.class);
	
    @Autowired
    RestTemplate restTemplate;
    
    /**
     * 测试是否启动成功和负载均衡日志查看
     * @return
     */
    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloController() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }
    
    /**
     * getForEntity-通过服务名调用
     * 响应消息体
     * 响应码、
     * contentType、contentLength、
     * @return
     */
    @RequestMapping("/gethello")
    public String getHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }
    
    /**
     * 请求的时候传递一个参数
     * @return
     */
    @RequestMapping("/sayHello")
    public String sayHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayHello?name={1}", String.class, "张三");
        return responseEntity.getBody();
    }
    
    /**
     * 请求的时候传递多个参数
     * @return
     */
    @RequestMapping("/sayNameAndAge")
    public String sayNameAndAge() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "李四");
        map.put("age", "22");
        logger.info("----- ConsumerController sayNameAndAge 进入");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayNameAndAge?name={name}&age={age}", String.class, map);
        return responseEntity.getBody();
    }
    
    /**
     * post
     * 请求的时候传递多个参数
     * @return
     */
    @RequestMapping("/sayNameAndAge2")
    public String sayNameAndAge2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "小王");
        map.put("age", "33");
        logger.info("----- ConsumerController sayNameAndAge2 进入");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE/sayNameAndAge2",map,String.class);
        return responseEntity.getBody();
    }
    
    /**
     * 返回提供者的一个实体.消费者需要依赖于提供者pom
     * @return
     */
    @RequestMapping("/sayBook")
    public Book sayBook() {
    	logger.info("----- ConsumerController getBook 进入");
    	Book responseEntity = restTemplate.getForObject("http://HELLO-SERVICE/sayBook", Book.class);
        return responseEntity;
    }
    
}

package com.zm.spring.hyatrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 开启仪表盘
 * springboot启动类
 * @author yp-tc-m-7129
 *
 */
@EnableHystrixDashboard
@SpringBootApplication
public class EurekaApplication {
	
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
  
}

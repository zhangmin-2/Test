package com.zm.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.zm.provider.dao")
@EnableDiscoveryClient
@SpringBootApplication

/**
 * 扫描包地址
 * 服务注册和发现
 * 启动类
 * @author yp-tc-m-7129
 *
 */
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}

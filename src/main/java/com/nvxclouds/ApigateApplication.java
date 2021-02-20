package com.nvxclouds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/23 15:31
 * @Description: 网关启动类
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApigateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApigateApplication.class,args);
    }

}

package com.autohome.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-08 23:04
 **/

@EnableDiscoveryClient //发布服务
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.autohome.server.dao")
public class UsedCarServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsedCarServerApplication.class, args);
    }
}

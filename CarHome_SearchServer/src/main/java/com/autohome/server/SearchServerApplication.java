package com.autohome.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.autohome.server.dao")
public class SearchServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchServerApplication.class, args);
    }
}

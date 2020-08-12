package com.autohome.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: BootSsm
 * @description:
 * @author: Feri
 * @create: 2019-10-21 15:01
 */
@Configuration //配置文件
@EnableSwagger2 //启用Swagger
public class SwaggerConfig {
    //创建文档说明
    public ApiInfo createAI(){
        ApiInfo apiInfo=new ApiInfoBuilder().title("开放平台的主站的后端接口文档").
                description("开放平台的主站的项目的所有接口信息，可以查看对应的接口信息和对接口进行测试").
                contact(new Contact("Feri","http://www.17feri.top","xingfei_work@163.com")).build();
        return apiInfo;
    }

    //创建Swagger扫描信息
    @Bean
    public Docket createD(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAI()).select().
                apis(RequestHandlerSelectors.basePackage("com.laoxing.open.api.api")).build();
    }
}
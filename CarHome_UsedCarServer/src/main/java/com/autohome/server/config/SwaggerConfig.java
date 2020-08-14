package com.autohome.server.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: special_offer_mall
 * @description:开启服务后访问http://localhost:8081/swagger-ui.html可以查看所有接口
 * @author:
 * @create: 2020-07-13 19:58
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商城")
                .description("这个程序写的真好呀")
                .termsOfServiceUrl("https://www.baidu.com")
                .version("1.0").contact(new Contact("CC","http://www.17feri.top","xingfei_work@163.com"))
                .build();
    }
}

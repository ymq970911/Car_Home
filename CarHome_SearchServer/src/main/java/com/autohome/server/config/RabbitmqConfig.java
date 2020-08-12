package com.autohome.server.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 16:19
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue createQue(){
        return new Queue("car-synces");
    }

}

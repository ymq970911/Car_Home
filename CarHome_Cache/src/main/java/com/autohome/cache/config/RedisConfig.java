package com.autohome.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: FmOpen
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-08-06 10:05
 */
@Configuration
@EnableCaching //启用缓存
public class RedisConfig extends CachingConfigurerSupport {
    //自定义Redis的key的生成策略
    @Override
    public KeyGenerator keyGenerator() {
        /**
         * 生成策略：
         * 1.target 类
         * 2.method 方法
         * 3.params 参数*/
        return (target, method, params) -> {
            StringBuffer buffer = new StringBuffer();
            buffer.append(target.getClass().getName() + ":");
            buffer.append(method.getName() + ":");
            for (Object o : params) {
                buffer.append(o.toString());
            }
            return buffer.toString();
        };
    }

    //transient String msg;
    //创建缓存管理器
    @Bean
    public CacheManager createCM(LettuceConnectionFactory connectionFactory) {
        //Redis写入对象
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        return new RedisCacheManager(writer, RedisCacheConfiguration.defaultCacheConfig());
    }

    //重新Redis操作模板对象，可以存储任意类型：对象存储 使用序列化存储 实现序列化接口
    @Bean
    public RedisTemplate<String, Object> createRT(LettuceConnectionFactory connectionFactory) {
        //实例化对象
        RedisTemplate<String, Object> template = new RedisTemplate();
        //设置连接对象
        template.setConnectionFactory(connectionFactory);
        //设置序列化格式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        //设置内容的序列化存储
        Jackson2JsonRedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //设置序列化
        ObjectMapper mapper = new ObjectMapper();
        //设置
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //已过时
        //mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //新版本
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        //字符串、set、List、ZSet
        template.setValueSerializer(redisSerializer);
        //Hash
        template.setHashKeySerializer(redisSerializer);

        return template;
    }
}

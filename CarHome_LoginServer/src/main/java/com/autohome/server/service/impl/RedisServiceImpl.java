package com.autohome.server.service.impl;

import com.autohome.common.dto.RedisStrDto;
import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import com.autohome.server.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: RedisServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/12 20:59
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R saveStr2Redis(String key, long times, String value) {
        RedisStrDto dto = new RedisStrDto(key, times, value);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RedisStrDto> requestEntity = new HttpEntity<>(dto, requestHeaders);
        return restTemplate.postForObject("http://cacheserver/cache/api/savestr.do", requestEntity, R.class);
    }

    @Override
    public R getStrFromRedis(String key) {
        return restTemplate.getForObject("http://cacheserver/cache/api/getstr.do", R.class);
    }
}

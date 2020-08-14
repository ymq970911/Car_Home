package com.autohome.server.service;

import com.autohome.common.vo.R;
import com.autohome.server.dto.RedisStrDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cacheserver")
public interface RedisService {
    @PostMapping(value = "/cache/api/savestr.do")
    R saveStr2Redis(@RequestBody RedisStrDto dto);

    @GetMapping("/cache/api/getstr.do")
    R getStrFromRedis(String key);

}

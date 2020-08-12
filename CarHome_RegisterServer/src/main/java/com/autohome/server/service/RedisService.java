package com.autohome.server.service;

import com.autohome.common.vo.R;
import org.apache.ibatis.cache.CacheException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cacheserver")
public interface RedisService {
    @PostMapping(value = "/cache/api/savestr.do")
     R saveStr2Redis(@RequestParam String key, @RequestParam long times, @RequestParam String value);

    @GetMapping("/cache/api/getstr.do")
    public R getStrFromRedis(String key);

}

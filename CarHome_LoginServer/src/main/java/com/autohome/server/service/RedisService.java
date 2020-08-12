package com.autohome.server.service;

import com.autohome.common.vo.R;

//@FeignClient("cacheserver")
public interface RedisService {
    //@GetMapping(value = "/cache/api/savestr.do")
    R saveStr2Redis(String key, long times, String value);

    //@GetMapping("/cache/api/getstr.do")
    R getStrFromRedis(String key);

}
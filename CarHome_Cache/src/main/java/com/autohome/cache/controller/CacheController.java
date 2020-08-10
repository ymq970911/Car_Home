package com.autohome.cache.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.autohome.cache.exception.CacheException;
import com.autohome.cache.service.CacheService;
import com.autohome.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: FmOpen
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-08-06 10:35
 */
@RestController
@RequestMapping("/cache/api")
@Slf4j
public class CacheController {
    @Autowired
    private CacheService service;

    //实现常用的操作
    @SentinelResource(fallback = "saveError")
    @PostMapping("/savestr.do")
    public R save(@RequestParam String key, @RequestParam long times, @RequestParam String value) throws CacheException {
        return R.ok(service.saveStr2Redis(key, times, value));
    }

    //降级方法
    public R saveError(String key, long times, String value) throws CacheException {
        log.error("缓存服务崩溃");
        return R.fail("服务器崩溃降级");
    }
}

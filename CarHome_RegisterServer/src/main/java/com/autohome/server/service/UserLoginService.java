package com.autohome.server.service;

import com.autohome.common.vo.R;
import org.apache.ibatis.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("login")
public interface UserLoginService {
    @PostMapping(value = "login/userlogin.do/{str}/{psw}")
    R checkUser(@PathVariable("str") String str, @PathVariable("psw") String psw);
}

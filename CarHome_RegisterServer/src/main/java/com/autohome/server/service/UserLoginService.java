package com.autohome.server.service;

import com.autohome.common.vo.R;
import org.apache.ibatis.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("login")
public interface UserLoginService {
    @PostMapping(value = "login/userlogin.do")
    public R checkUser(String str,String psw);
}

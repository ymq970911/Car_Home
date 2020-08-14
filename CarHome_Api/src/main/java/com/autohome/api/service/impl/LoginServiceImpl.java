package com.autohome.api.service.impl;

import com.autohome.api.service.LoginService;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R checkUser(String str, String psw) {
        return restTemplate.getForObject("http://login/userlogin.do/" + str + "/" + psw, R.class);
    }
}

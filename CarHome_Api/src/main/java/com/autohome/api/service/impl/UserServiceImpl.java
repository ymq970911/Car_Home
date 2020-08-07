package com.autohome.api.service.impl;

import com.autohome.api.service.UserService;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R checkN(String name) {
        return restTemplate.getForObject("http://server/server/user/checkname.do?name=" + name, R.class);
    }
}

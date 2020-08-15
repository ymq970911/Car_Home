package com.autohome.api.service.impl;

import com.autohome.api.service.LoginService;
import com.autohome.common.dto.LoginDto;
import com.autohome.common.dto.UserDto;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R checkUser(String str, String psw) {
        return restTemplate.getForObject("http://loginserver/login/user/login.do/" + str + "/" + psw, R.class);
    }

    @Override
    public R changePass(String token, String pass) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("usertoken", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(pass, requestHeaders);
        return restTemplate.postForObject("http://loginserver/login/user/changepass.do", requestEntity, R.class);
    }

    @Override
    public R loginout(String token) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("usertoken", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        return restTemplate.postForObject("http://loginserver/login/user/loginout.do", requestEntity, R.class);
    }

    @Override
    public R checkToken(String token) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("usertoken", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        return restTemplate.postForObject("http://loginserver/login/user/checktoken.do", requestEntity, R.class);
    }

    @Override
    public R toLogin(LoginDto dto) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginDto> requestEntity = new HttpEntity<>(dto, requestHeaders);
        return restTemplate.postForObject("http://loginserver/login/user/tologin.do", requestEntity, R.class);
    }
}

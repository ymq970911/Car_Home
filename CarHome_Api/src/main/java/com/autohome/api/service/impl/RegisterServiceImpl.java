package com.autohome.api.service.impl;

import com.autohome.api.service.RegisterService;
import com.autohome.common.dto.UserDto;
import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R sendMail(String to) {
        return restTemplate.getForObject("http://register/register/sendMail.do/" + to, R.class);
    }

    @Override
    public R createUserByEmial(String code, String email) {
        return restTemplate.getForObject("http://register/register/createUserByEmial.do/" + code + "/" + email, R.class);
    }

    @Override
    public R createUserPhone(String code, String phone) {
        return restTemplate.getForObject("http://register/register/createUserPhone.do/" + code + "/" + phone, R.class);
    }

    @Override
    public R checkCode(String to, String code) {
        return restTemplate.getForObject("http://register/register/createUserPhone.do?to=" + to + "&code=" + code, R.class);
    }

    @Override
    public R regUser(UserDto dto) {
        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDto> requestEntity = new HttpEntity<>(dto, requestHeaders);
        return restTemplate.postForObject("http://register/register/reguser.do", requestEntity, R.class);
    }

    @Override
    public R checkPhone(String phone) {
        return restTemplate.getForObject("http://register/register/checkphone.do/" + phone, R.class);
    }

    @Override
    public R findPass(UserDto dto) {
        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDto> requestEntity = new HttpEntity<>(dto, requestHeaders);
        return restTemplate.postForObject("http://register/register/findpass.do", requestEntity, R.class);
    }
}

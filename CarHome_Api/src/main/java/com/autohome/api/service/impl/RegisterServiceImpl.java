package com.autohome.api.service.impl;

import com.autohome.api.service.RegisterService;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R sendMail(String to) {
      return   restTemplate.getForObject("http://register/sendMail.do"
                +to,R.class);
    }

    @Override
    public R createUserByEmial(String code, String email) {
        return   restTemplate.getForObject("http://register/createUserByEmial.do"
                +code+email,R.class);
    }

    @Override
    public R createUserPhone(String code, String phone) {
        return   restTemplate.getForObject("http://register/createUserPhone.do"
                +code+phone,R.class);
    }
}

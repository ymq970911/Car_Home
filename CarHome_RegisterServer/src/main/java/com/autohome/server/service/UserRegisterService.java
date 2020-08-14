package com.autohome.server.service;

import com.autohome.common.vo.R;
import com.autohome.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


public interface UserRegisterService {

    R sendMail(String to);

    R createUserByEmial(String code,String email);

    R createUserPhone(String code,String phone);

}

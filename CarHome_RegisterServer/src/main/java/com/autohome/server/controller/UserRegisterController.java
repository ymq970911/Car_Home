package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.server.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping("/sendMail.do")
    public R sendMail(String to) {
        return  userRegisterService.sendMail(to);
    }

    @RequestMapping("/createUserByEmial.do")
    public R createUserByEmial(String code, String email){
        return userRegisterService.createUserByEmial(code,email);

    }
}

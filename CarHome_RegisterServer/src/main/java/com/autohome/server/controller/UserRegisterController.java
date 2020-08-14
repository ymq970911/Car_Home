package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.server.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
    private UserRegisterService service;

    @GetMapping("/sendMail.do/{to}")
    public R sendMail(@PathVariable String to) {
        return service.sendMail(to);
    }

    @GetMapping("/createUserByEmial.do")
    public R createUserByEmial(String code, String email) {
        return service.createUserByEmial(code, email);

    }
}

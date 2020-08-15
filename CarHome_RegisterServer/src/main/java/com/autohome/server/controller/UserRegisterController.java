package com.autohome.server.controller;

import com.autohome.common.dto.UserDto;
import com.autohome.common.vo.R;
import com.autohome.server.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/checkcode.do")
    public R checkCode(String to, String code) {
        return service.checkCode(to, code);
    }

    @PostMapping("/reguser.do")
    public R regUser(@RequestBody UserDto dto) {
        return service.regUser(dto);
    }

    @GetMapping("/checkphone.do/{phone}")
    public R checkPhone(@PathVariable String phone) {
        return service.checkPhone(phone);
    }
}

package com.autohome.api.controller;

import com.autohome.api.service.RegisterService;
import com.autohome.common.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户注册模块接口")
@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @GetMapping("/sendMail.do/{to}")
    public R sendMail(@PathVariable String to) {
        return registerService.sendMail(to);
    }

    @PostMapping("/createUserByEmial.do/{code}/{email}")
    public R createUserByEmial(@PathVariable String code, @PathVariable String email) {
        return createUserByEmial(code, email);

    }
}

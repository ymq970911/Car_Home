package com.autohome.api.controller;

import com.autohome.api.service.RegisterService;
import com.autohome.common.constant.SystemConstant;
import com.autohome.common.dto.UserDto;
import com.autohome.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户注册模块接口")
@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private RegisterService service;

    @ApiOperation("发送邮件验证码")
    @GetMapping("/sendMail.do/{to}")
    public R sendMail(@PathVariable String to) {
        return service.sendMail(to);
    }

    @ApiOperation(value = "邮箱注册(邮箱验证码)", notes = "通过邮箱验证码生成随机账号和密码")
    @PostMapping("/createUserByEmial.do/{code}/{email}")
    public R createUserByEmial(@PathVariable String code, @PathVariable String email) {
        return createUserByEmial(code, email);

    }

    @ApiOperation(value = "校验邮箱验证码", notes = "通过邮箱账号和验证码进行校验")
    @GetMapping("/checkcode.do")
    public R checkCode(String to, String code) {
        return service.checkCode(to, code);
    }

    @ApiOperation(value = "用户名注册", notes = "填入必填信息进行普通注册")
    @PostMapping("/reguser.do")
    public R regUser(@RequestBody UserDto dto) {
        return service.regUser(dto);
    }

    @ApiOperation(value = "校验手机号", notes = "校验手机号是否存在")
    @GetMapping("/checkphone.do/{phone}")
    public R checkPhone(@PathVariable String phone) {
        return service.checkPhone(phone);
    }

    @ApiOperation(value = "找回密码(重置)", notes = "找回密码，通过手机验证码重设密码")
    @PostMapping("/findpass")
    public R findPass(@RequestBody UserDto dto){
        return service.findPass(dto);
    }
}

package com.autohome.server.controller;

import com.autohome.common.constant.SystemConstant;
import com.autohome.common.dto.LoginDto;
import com.autohome.common.vo.R;
import com.autohome.server.service.UserLoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login/user")
public class UserLoginController {
    @Autowired
    private UserLoginService service;

    @RequestMapping("/login.do")
    public R userLoginController(String str, String psw) {
        return service.checkUser(str, psw);
    }

    @ApiOperation(value = "手机/邮箱/账号+密码登陆", notes = "使用手机或邮箱或账号，加上密码直接登陆")
    @PostMapping("/tologin.do")
    public R toLogin(@RequestBody LoginDto dto) {
        return service.toLogin(dto);
    }


    @ApiOperation(value = "修改密码", notes = "校验已登陆的情况来直接重置密码")
    @PostMapping("/changepass.do")
    public R changePass(HttpServletRequest request, String pass) {
        return service.changePass(request.getHeader(SystemConstant.TOKEN_USER), pass);
    }

    @ApiOperation(value = "登出", notes = "注销登陆")
    @GetMapping("/loginout.do")
    public R loginout(HttpServletRequest request) {
        return service.loginout(request.getHeader(SystemConstant.TOKEN_USER));
    }

    @ApiOperation(value = "校验令牌", notes = "通过Http Header中携带的token校验token是否可用")
    @PostMapping("/checktoken.do")
    public R checkToken(HttpServletRequest request) {
        return service.checkToken(request.getHeader("usertoken"));
    }
}

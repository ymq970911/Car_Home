package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.server.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/userlogin.do")
    public R userLoginController(String str,String psw){

        R r = userLoginService.checkUser(str, psw);
        return r;
    }
}

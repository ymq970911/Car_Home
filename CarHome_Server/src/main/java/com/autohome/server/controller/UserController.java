package com.autohome.server.controller;


import com.autohome.common.vo.R;
import com.autohome.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server/user/")
public class UserController {
    @Autowired
    private UserService service;

    //校验昵称是否可用
    @GetMapping("checkname.do")
    public R check(@RequestParam String name){
        return service.checkNickname(name);
    }
}
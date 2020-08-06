package com.autohome.api.controller;

import com.autohome.api.service.UserService;
import com.autohome.common.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户服务相关操作")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;

    //校验昵称
    @GetMapping("/checknickname/{name}")
    public R check(@PathVariable String name) {
        return service.checkN(name);
    }

}

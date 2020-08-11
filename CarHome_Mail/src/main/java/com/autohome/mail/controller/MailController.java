package com.autohome.mail.controller;

import com.autohome.common.vo.R;
import com.autohome.mail.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
@Api
public class MailController {
    @Autowired
    private MailService mailServcer;

    @GetMapping("/sendCodeMail.do")
    public R sendMail(@RequestParam String to,@RequestParam String str) {
        R r = mailServcer.sendCodeMail(to,str);
        return r;
    }

    @GetMapping("/sendUserMail.do")
    public R sendUserMail(@RequestParam String to,@RequestParam String name,
                          @RequestParam String password) {
        R r = mailServcer.sendUserMail(to,name,password);
        return r;
    }



}

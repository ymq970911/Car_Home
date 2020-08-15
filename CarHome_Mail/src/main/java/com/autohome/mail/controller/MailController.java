package com.autohome.mail.controller;

import com.autohome.common.vo.R;
import com.autohome.mail.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailServcer;

    @GetMapping("/sendCodeMail.do")
    public R sendMail(String to, String str) {
        return mailServcer.sendCodeMail(to, str);
    }
}
package com.autohome.server.service;

import com.autohome.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("mail")
public interface MailService {
    @GetMapping(value = "mail/sendCodeMail.do")
    R sendMail(String to,String str);
    @GetMapping(value = "mail/sendUserMail.do")
    R sendUserMail( String to,String name,String password);
}

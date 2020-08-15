package com.autohome.server.service;

import com.autohome.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface MailService {
    R sendMail(String to, String str);

    R sendUserMail(String to, String name, String password);
}

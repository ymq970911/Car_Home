package com.autohome.mail.service.impl;

import com.autohome.common.email.MailUtil;
import com.autohome.common.vo.R;
import com.autohome.mail.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServciceImpl implements MailService {

    @Override
    public R sendCodeMail(String to, String str) {
        MailUtil.sendMail(to, str);
        return R.ok();
    }
}

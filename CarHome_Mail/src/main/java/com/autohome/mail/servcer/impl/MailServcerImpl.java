package com.autohome.mail.servcer.impl;

import com.autohome.common.email.MailUtil;
import com.autohome.common.vo.R;
import com.autohome.mail.servcer.MailServcer;
import org.springframework.stereotype.Service;

@Service
public class MailServcerImpl implements MailServcer {

    @Override
    public R sendMail(String to) {

        String string = MailUtil.generateRandomCode(6);

       MailUtil.sendMail(to,string);


        return R.ok();
    }
}

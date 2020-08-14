package com.autohome.server.service.impl;

import com.autohome.common.vo.R;
import com.autohome.server.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: MailServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/12 21:09
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R sendMail(String to, String str) {
        return restTemplate.getForObject("http://mailserver/mail/sendCodeMail.do?to=" + to + "&str=" + str, R.class);
    }

    @Override
    public R sendUserMail(String to, String name, String password) {
        return restTemplate.getForObject("http://mailserver/mail/sendUserMail.do?to=" + to + "&name=" + name + "&password=" + password, R.class);
    }
}

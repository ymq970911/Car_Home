package com.autohome.mail.service;

import com.autohome.common.vo.R;
import com.autohome.entity.User;

public interface MailService {
    R sendCodeMail(String to, String str);
}

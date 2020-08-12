package com.autohome.mail.service;

import com.autohome.common.vo.R;
import com.autohome.entity.User;

public interface MailService {
//    R sendMail(String to,String str);

    R sendCodeMail(String to,String str);

    R sendUserMail(String to,String name,String passWord);



}

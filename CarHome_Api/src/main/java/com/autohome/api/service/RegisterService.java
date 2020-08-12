package com.autohome.api.service;

import com.autohome.common.vo.R;

public interface RegisterService {
    R sendMail(String to);

    R createUserByEmial(String code,String email);

    R createUserPhone(String code,String phone);
}

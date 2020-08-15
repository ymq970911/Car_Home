package com.autohome.api.service;

import com.autohome.common.dto.UserDto;
import com.autohome.common.vo.R;

public interface RegisterService {
    R sendMail(String to);

    R createUserByEmial(String code,String email);

    R createUserPhone(String code,String phone);

    R checkCode(String to, String code);

    R regUser(UserDto dto);

    R checkPhone(String phone);

    R findPass(UserDto dto);
}

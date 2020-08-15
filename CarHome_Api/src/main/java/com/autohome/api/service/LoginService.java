package com.autohome.api.service;

import com.autohome.common.dto.LoginDto;
import com.autohome.common.vo.R;

public interface LoginService {
    R checkUser(String str, String psw);

    R changePass(String token, String pass);

    R loginout(String token);

    R checkToken(String token);

    R toLogin(LoginDto dto);
}

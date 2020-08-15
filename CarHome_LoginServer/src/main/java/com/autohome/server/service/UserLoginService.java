package com.autohome.server.service;

import com.autohome.common.dto.LoginDto;
import com.autohome.common.vo.R;

public interface UserLoginService {
    R checkUser(String str, String psw);

    R changePass(String token, String pass);

    R loginout(String token);

    R checkToken(String token);

    R toLogin(LoginDto dto);
}

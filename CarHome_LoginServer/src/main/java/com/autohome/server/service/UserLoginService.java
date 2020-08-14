package com.autohome.server.service;

import com.autohome.common.vo.R;

public interface UserLoginService {
    R checkUser(String str,String psw);
}

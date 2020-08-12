package com.autohome.api.service;

import com.autohome.common.vo.R;

public interface LoginService {
    R checkUser(String str, String psw);
}

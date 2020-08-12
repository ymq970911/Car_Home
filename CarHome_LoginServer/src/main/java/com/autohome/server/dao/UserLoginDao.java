package com.autohome.server.dao;

import com.autohome.common.dto.UserLoginDto;

public interface UserLoginDao {
    UserLoginDto selectUser(String str,String psw);
}

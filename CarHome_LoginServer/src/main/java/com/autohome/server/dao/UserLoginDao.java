package com.autohome.server.dao;

import com.autohome.common.dto.UserLoginDto;
import com.autohome.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserLoginDao {
    UserLoginDto selectUser(@Param("username") String str, @Param("password") String psw);

    User checkAccount(String account);

    String getPwdByUsername(String username);

    int changePsw(@Param("username") String username, @Param("password") String password);

    String selectUsernameByAccount(String account);
}

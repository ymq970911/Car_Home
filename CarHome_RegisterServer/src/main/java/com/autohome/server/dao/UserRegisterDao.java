package com.autohome.server.dao;

import com.autohome.common.dto.UserLoginDto;
import com.autohome.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegisterDao {

    void insertUser(UserLoginDto user);

    List<UserLoginDto> selectOneUser(String str);

//    void changePsw(int uid,String pws);

}

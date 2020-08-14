package com.autohome.server.dao;

import com.autohome.common.dto.UserLoginDto;
import com.autohome.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegisterDao {

    void insertUser(UserLoginDto user);

    User selectUserByUsername(String username);

    User selectUserByEmail(String email);

    List<String> selectAll();

//    void changePsw(int uid,String pws);

}

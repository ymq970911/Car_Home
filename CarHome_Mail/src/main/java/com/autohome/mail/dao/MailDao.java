package com.autohome.mail.dao;

import com.autohome.common.dto.UserLoginDto;
import com.autohome.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MailDao {
    List<User> selectMail(String mail);

    Void insterUser(UserLoginDto user);

    List<User> selectUser(UserLoginDto user);
}

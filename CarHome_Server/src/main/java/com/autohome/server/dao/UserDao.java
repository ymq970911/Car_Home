package com.autohome.server.dao;


import com.autohome.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User selectByNickName(String name);
}

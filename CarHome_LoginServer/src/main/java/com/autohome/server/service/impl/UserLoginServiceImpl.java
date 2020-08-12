package com.autohome.server.service.impl;

import com.autohome.common.dto.UserLoginDto;
import com.autohome.common.vo.R;
import com.autohome.server.dao.UserLoginDao;
import com.autohome.server.service.RedisService;
import com.autohome.server.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.autohome.common.constant.SystemConstant.TOKEN_TIME;
import static com.autohome.common.constant.SystemConstant.USERLOGIN_TOKEN;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginDao userLoginDao;
    @Autowired
    private RedisService redisService;


    @Override
    public R checkUser(String str,String psw) {

        UserLoginDto user = userLoginDao.selectUser(str,psw);
        //根据用户输入的账号，密码查询数据库
        if (user != null){
            R r = redisService.saveStr2Redis(USERLOGIN_TOKEN + str, TOKEN_TIME, user.toString());
            return r;
        }else {
            return R.fail("账号密码错误，请重试");
        }

        }
        //校验用户是否存在


}

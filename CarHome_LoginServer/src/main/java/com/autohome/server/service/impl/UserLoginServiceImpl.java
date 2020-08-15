package com.autohome.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.autohome.common.dto.LoginDto;
import com.autohome.common.dto.UserLoginDto;
import com.autohome.common.jwt.JwtUtil;
import com.autohome.common.util.EncryptUtil;
import com.autohome.common.util.StringUtil;
import com.autohome.common.vo.R;
import com.autohome.entity.User;
import com.autohome.server.dao.UserLoginDao;
import com.autohome.server.service.RedisService;
import com.autohome.server.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.autohome.common.constant.SystemConstant.TOKEN_TIME;
import static com.autohome.common.constant.SystemConstant.USERLOGIN_TOKEN;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginDao dao;
    @Autowired
    private RedisService cache;

    @Value("${carhome.user.aeskey}")
    private String aesKey;

    @Override
    public R checkUser(String str, String psw) {
        UserLoginDto user = dao.selectUser(str, psw);
        //根据用户输入的账号，密码查询数据库
        if (user != null) {
            return cache.saveStr2Redis(USERLOGIN_TOKEN + str, TOKEN_TIME, user.toString());
        } else {
            return R.fail("账号密码错误，请重试");
        }
    }

    @Override
    public R toLogin(LoginDto dto) {
        String account = dto.getAccount();
        String password = dto.getPassword();

        // 优先校验token，看是否已登陆
        R r = cache.checkKeyFromRedis(USERLOGIN_TOKEN + dao.selectUsernameByAccount(account));
        if (r.getCode() == 200) {
            if ("true".equals(r.getData())) {
                R.ok("亲，您已经登陆了！");
            }
        }

        // account 可能是手机、邮箱、账号
        if (StringUtil.isnoEmpty(account) && StringUtil.isnoEmpty(password)) {
            // 校验手机、邮箱、账号是否能存在，以及密码是否匹配
            User user = dao.checkAccount(account);
            if (null != user) {
                // 非空，可以登陆
                String pwd = EncryptUtil.aesdec(aesKey, dao.getPwdByUsername(user.getUsername()));
                if (password.equals(pwd)) {
                    // 生成token存储cache
                    String token = JwtUtil.createJWT(account);
                    log.info("token:" + token);
                    cache.saveStr2Redis(USERLOGIN_TOKEN + token, TOKEN_TIME, JSON.toJSONString(user));
                    cache.saveStr2Redis(USERLOGIN_TOKEN + user.getUsername(), TOKEN_TIME, token);
                    // 记录日志
                    log.info("登陆成功！");
                    return R.ok("token:" + token);
                }
            }
        }
        return R.fail("账号或密码输入错误！");
    }

    @Override
    public R changePass(String token, String pass) {
        if ("true".equals(cache.checkKeyFromRedis(USERLOGIN_TOKEN + token).getData())) {
            User user = JSON.parseObject(cache.getStrFromRedis(USERLOGIN_TOKEN + token).getData().toString(), User.class);
            if (dao.changePsw(user.getUsername(), EncryptUtil.aesenc(aesKey, pass)) > 0) {
                //删除令牌
                cache.delkeyFromRedis(USERLOGIN_TOKEN + token);
                return R.ok("密码修改成功，请重新登录");
            }
        }
        return R.fail("密码修改失败");
    }

    @Override
    public R loginout(String token) {
        if (StringUtil.isnoEmpty(token)) {
            R r = cache.delkeyFromRedis(USERLOGIN_TOKEN + token);
            if (r.getCode() == 200) {
                if ("true".equals(r.getData())) {
                    return R.ok("注销成功！");
                }
            }
        }
        return R.fail("请传递token！");
    }

    @Override
    public R checkToken(String token) {
        if (StringUtil.isnoEmpty(token)) {
            // 获取key，能获取到就没有过期，反之则过期
            R r = cache.checkKeyFromRedis(USERLOGIN_TOKEN + token);
            if (r.getCode() == 200) {
                if (StringUtil.isnoEmpty(r.getData().toString())) {
                    R.ok("token有效");
                }
            }
        }
        return R.fail("token或账户名有误！");
    }
}

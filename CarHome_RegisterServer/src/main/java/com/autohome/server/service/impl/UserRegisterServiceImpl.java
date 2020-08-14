package com.autohome.server.service.impl;

import com.autohome.common.dto.UserLoginDto;
import com.autohome.common.email.MailUtil;
import com.autohome.common.vo.R;
import com.autohome.server.dao.UserRegisterDao;
import com.autohome.server.dto.RedisStrDto;
import com.autohome.server.service.MailService;
import com.autohome.server.service.RedisService;
import com.autohome.server.service.UserLoginService;
import com.autohome.server.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.autohome.common.constant.SystemConstant.REGISTER_CODE;
import static com.autohome.common.constant.SystemConstant.TOKENMAIL_TIME;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserRegisterDao userLoginDao;

    @Autowired
    private MailService mailService;

    @Autowired
    private RedisService redisServicer;

    @Autowired
    private UserLoginService userLoginService;

    //将验证码放入redis中，设置时间为5分钟；
    @Override
    public R sendMail(String to) {
        //验证邮箱是否已被注册
        if (null == userLoginDao.selectUserByEmail(to)) {
            //生成随机6位验证码
            String code = MailUtil.generateRandomCode(6);
            //将验证码放入redis中，设置时间为5分钟
            if (redisServicer.saveStr2Redis(new RedisStrDto(REGISTER_CODE + to, TOKENMAIL_TIME, code)).getCode() != 200) {
                return R.fail("存储失败");
            }
            //调用mail服务；
            return mailService.sendMail(to, code);
        } else {
            return R.fail("您输入的邮箱已经被注册啦");
        }
    }

    @Override
    public R createUserByEmial(String code, String email) {
        //获取Redis中的验证码
        R strFromRedis = redisServicer.getStrFromRedis(email);

        if (strFromRedis.getMsg().equals(code)) {
            UserLoginDto dto = new UserLoginDto();
            dto.setMail(email);
            do {
                String name = MailUtil.generateRandomCode(6);
                String password = MailUtil.generateRandomCode(6);
                dto.setUserName(name);
                dto.setPsw(password);
            }  //生成一个随机账号，密码，用户名，邮箱为输入的邮箱的账号
            while (userLoginDao.selectAll().isEmpty());
            {
                //判断生成的账号是否重复，若重复则重新新生成
                userLoginDao.insertUser(dto);
                //将生成的对象插入到数据库
                if (userLoginDao.selectUserByUsername(dto.getUserName()) != null) {
                    userLoginService.checkUser(dto.getUserName(), dto.getPsw());
                    //调用登录服务
                }
                return mailService.sendUserMail(email, dto.getUserName(), dto.getPsw());
                // 调用mail服务，并将用户名和密码其发送到用户邮箱中
            }
        } else {
            return R.fail("验证码错误，请您输入正确的验证码");
        }
    }

    @Override
    public R createUserPhone(String code, String phone) {
        return null;
    }
}

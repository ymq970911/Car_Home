package com.autohome.server.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.autohome.common.dto.UserDto;
import com.autohome.common.dto.UserLoginDto;
import com.autohome.common.email.MailUtil;
import com.autohome.common.util.BeanUtil;
import com.autohome.common.util.EncryptUtil;
import com.autohome.common.util.StringUtil;
import com.autohome.common.vo.R;
import com.autohome.entity.User;
import com.autohome.server.dao.UserRegisterDao;
import com.autohome.server.dto.RedisStrDto;
import com.autohome.server.service.MailService;
import com.autohome.server.service.RedisService;
import com.autohome.server.service.UserLoginService;
import com.autohome.server.service.UserRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.autohome.common.constant.SystemConstant.REGISTER_CODE;
import static com.autohome.common.constant.SystemConstant.TOKENMAIL_TIME;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserRegisterDao dao;

    @Autowired
    private MailService mailService;

    @Autowired
    private RedisService redisServicer;

    @Autowired
    private UserLoginService userLoginService;

    @Value("${carhome.user.aeskey}")
    private String aesKey;

    //将验证码放入redis中，设置时间为5分钟；
    @Override
    public R sendMail(String to) {
        //验证邮箱是否已被注册
        if (null == dao.selectUserByEmail(to)) {
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
            while (dao.selectAll().isEmpty());
            {
                //判断生成的账号是否重复，若重复则重新新生成
                dao.insertUser(dto);
                //将生成的对象插入到数据库
                if (dao.selectUserByUsername(dto.getUserName()) != null) {
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
        R r = redisServicer.getStrFromRedis(REGISTER_CODE + phone);
        if (code.equals(r.getData().toString())) {
            return R.ok();
        }
        return R.fail("验证码有误！");

    }

    @Override
    public R checkCode(String to, String code) {
        R r = redisServicer.getStrFromRedis(REGISTER_CODE + to);
        if (code.equals(r.getData().toString())) {
            return R.ok();
        }
        return R.fail("验证码有误！");
    }

    @Override
    public R regUser(UserDto dto) {
        // 非空校验
        if (StringUtils.isEmpty(dto.getUsername()) || StringUtils.isEmpty(dto.getPassword())) {
            return R.fail("账号或密码不能为空！");
        }

        // 用户名和密码不同校验
        if (dto.getUsername().equals(dto.getPassword())) {
            return R.fail("账户名不能和密码相同");
        }

        // 敏感词校验 - 需配 key
        // if (!CensorUtil.checkText(dto.getUsername()) || !CensorUtil.checkText(dto.getName())) {
        //     return R.fail("用户名和姓名不合规，请检查！");
        // }

        // 用户名、手机、邮箱 唯一校验
        if (null != dao.selectUserByUsername(dto.getUsername()) || null != dao.selectUserByPhone(dto.getPhone()) || null != dao.selectUserByEmail(dto.getEmail())) {
            return R.fail("账户名或手机号或邮箱已存在");
        }

        // 拷贝dto到实体类
        User user = BeanUtil.copyDto(User.class, dto);
        // 生成密文密码
        user.setPassword(EncryptUtil.aesenc(aesKey, user.getPassword()));
        // 存储
        if (dao.insert(user) > 0) {
            return R.ok();
        }
        return R.fail("注册失败！");
    }

    @Override
    public R checkPhone(String phone) {
        if (StringUtil.isnoEmpty(phone)) {
            if (null == dao.selectUserByPhone(phone)) {
                // 返回空，手机号可用
                return R.ok();
            } else {
                return R.fail("手机号已存在");
            }
        } else {
            return R.fail("手机号不能为空");
        }
    }
}

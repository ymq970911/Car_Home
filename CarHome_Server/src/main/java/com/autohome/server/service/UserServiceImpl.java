package com.autohome.server.service;

import com.autohome.common.baidu.CensorUtil;
import com.autohome.common.util.StringUtil;
import com.autohome.common.vo.R;
import com.autohome.entity.User;
import com.autohome.server.dao.UserDao;
import com.autohome.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 17:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Value("${open.pass.prikey}")
    private String privatekey;

    @Override
    public R<String> checkNickname(String name) {
        //校验
        if(StringUtil.isnoEmpty(name)){
            //敏感词
            if(CensorUtil.checkText(name)){
                //校验数据库
                //User user=dao.selectByNickName(name.trim());
                //if(user==null){
                    return R.ok();
                //}
            }
        }
        return R.fail("昵称不合规或者已存在");
    }
}
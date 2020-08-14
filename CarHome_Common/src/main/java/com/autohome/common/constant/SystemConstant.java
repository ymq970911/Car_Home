package com.autohome.common.constant;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-29 12:02
 */
public class SystemConstant {
    public static final String OSS_BUCKET = "jy-imgs";
    public static final int OSSTYPE_IMG = 1;
    public static final int OSSTYPE_VEDIO = 2;
    public static final int OSSTYPE_JSON = 3;


    //mail
    public static final String REGISTER_CODE="mail:";
    public static final String USERLOGIN_TOKEN="user:";
    public static final String TOKEN_USER="voter:token:";
    //后面追加手机号 值存储用户信息
    //有效期
    public static final long TOKENMAIL_TIME=60*5L;//令牌有效期 单位秒
    public static final long TOKEN_TIME=60*30;//令牌有效期 单位秒
    public static final long TOKENFOR_TIME=60*30;//冻结账号 单位秒
    public static final long TOKENERROR_TIME=60*10;//错误的有效期
}

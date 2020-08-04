package com.autohome.common.enumeration;



public enum UserLogType {
    注册(1), 登陆(2), 密码修改(3), 密码找回(4);
    private int val;

    UserLogType(int v) {
        val = v;
    }

    public int getVal() {
        return val;
    }
}

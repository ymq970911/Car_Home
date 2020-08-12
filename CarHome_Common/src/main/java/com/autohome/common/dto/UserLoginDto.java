package com.autohome.common.dto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String userName;
    private String phone;
    private String mail;
    private String psw;
}

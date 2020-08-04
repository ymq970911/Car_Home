package com.autohome.common.dto;

import lombok.Data;

/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-29 11:03
 */
@Data
public class UserRegisterDto {
    private Integer type; //类型 1.个人 2.企业
    private String nickname;
    private String password;
    private String headurl;
}

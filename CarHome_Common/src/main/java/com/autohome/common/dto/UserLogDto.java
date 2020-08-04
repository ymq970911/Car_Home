package com.autohome.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-29 11:19
 */
@Data
public class UserLogDto {
    private Integer id;
    private Integer uid;
    private String nickname;
    private Integer utype;
    private Integer type;
    private String content;
    private LocalDateTime ctime;
}

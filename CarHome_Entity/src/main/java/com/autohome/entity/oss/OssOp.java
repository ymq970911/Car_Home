package com.autohome.entity.oss;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-29 12:08
 */
@Data
@NoArgsConstructor
public class OssOp {
    private Integer id;
    private String url;
    private Integer type;

    public OssOp(String url, Integer type) {
        this.url = url;
        this.type = type;
    }
}
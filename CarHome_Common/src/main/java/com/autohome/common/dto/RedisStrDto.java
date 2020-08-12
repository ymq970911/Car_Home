package com.autohome.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Class: RedisStrDto
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/12 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisStrDto {
    private String key;
    private Long times;
    private String value;
}

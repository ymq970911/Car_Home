package com.autohome.common.dto;

import lombok.Data;

@Data
public class ZsetDto {
    private String key;
    private Long times;
    private Double score;
    private String value;
}

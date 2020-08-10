package com.autohome.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServiceFirstLevelDto {
    private Integer id;

    private String name;

    List<ServiceSecondLevelDto> list;

}


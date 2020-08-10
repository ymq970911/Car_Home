package com.autohome.common.dto;

import lombok.Data;

import java.util.List;
/**
 * @author YMQ
 * 查询所有品牌下的全部类型的汽车
 */
@Data
public class GetCarByBrandIdDto {
    private String name;
    private String logo;//品牌URl
    private List<CarDto> car;
}

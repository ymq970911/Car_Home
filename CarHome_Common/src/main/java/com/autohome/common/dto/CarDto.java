package com.autohome.common.dto;

import lombok.Data;

/**
 * @author YMQ
 *查询对应品牌下全部类型和型号的车辆所需属性
 * */
@Data
public class CarDto {
    private Integer car_id;
    private String car_name;
    private Double car_price;
    private String url;
    private String model_level;
    private Integer type;
}

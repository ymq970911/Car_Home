package com.autohome.common.dto;

import lombok.Data;

/**
 * @author YMQ
 * 根据类型和汽车型号查询某品牌的车辆
 */
@Data
public class GetCarDto {
    private Integer id;
    private String car_name;
    private Double car_price;
    private String url;
    private String model_level;
    private String type;
}

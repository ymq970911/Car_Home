package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author YMQ
 */
@ApiModel(value = "com-autohome-entity-CarGeneral")
@Data
public class CarGeneral implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 车名
     */
    @ApiModelProperty(value = "车名")
    private String car_name;

    /**
     * 车型款式总述
     */
    @ApiModelProperty(value = "车型款式总述")
    private String style_description;

    /**
     * 车辆价格
     */
    @ApiModelProperty(value = "车辆价格")
    private Double car_price;

    /**
     * 厂商指导价格
     */
    @ApiModelProperty(value = "厂商指导价格")
    private Double guidance_price;

    /**
     * 款式发行年（年）
     */
    @ApiModelProperty(value = "款式发行年（年）")
    private String designed_time;

    /**
     * 制造商（也是品牌）
     */
    @ApiModelProperty(value = "制造商（也是品牌）")
    private String manufacturer;

    /**
     * 车型级别
     */
    @ApiModelProperty(value = "车型级别")
    private String model_level;

    /**
     * 排量
     */
    @ApiModelProperty(value = "排量")
    private String displacement;

    /**
     * 图片编号-外键
     */
    @ApiModelProperty(value = "汽车图片")
    private Integer img_id;

    /**
     * 关注度
     */
    @ApiModelProperty(value = "关注度")
    private Integer attention;


    @ApiModelProperty(value = "汽车类型 - 在售/未售")
    private Integer type;

    private static final long serialVersionUID = 1L;
}


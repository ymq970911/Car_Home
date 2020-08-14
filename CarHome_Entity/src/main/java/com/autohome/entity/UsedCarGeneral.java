package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@ApiModel(value = "com-autohome-entity-UsedCarGeneral")
@Data
public class UsedCarGeneral implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 汽车编号
     */
    @ApiModelProperty(value = "汽车编号")
    private Integer car_id;

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
     * 首次上牌时间（年.月）
     */
    @ApiModelProperty(value = "首次上牌时间（年.月）")
    private String car_registration_time;

    /**
     * 表现里数
     */
    @ApiModelProperty(value = "表现里数")
    private Double performance_mileage;

    /**
     * 准迁地标准
     */
    @ApiModelProperty(value = "准迁地标准")
    private String removal_standard;

    /**
     * 排量
     */
    @ApiModelProperty(value = "排量")
    private String displacement;

    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private Integer change_number;

    /**
     * 牌照地点
     */
    @ApiModelProperty(value = "牌照地点")
    private String license_location;

    /**
     * 上架时间
     */
    @ApiModelProperty(value = "上架时间")
    private Date upload_time;

    /**
     * 变速箱
     */
    @ApiModelProperty(value = "变速箱")
    private String gearbox;

    /**
     * 看车地点
     */
    @ApiModelProperty(value = "看车地点")
    private String meeting_place;

    /**
     * 车主id
     */
    @ApiModelProperty(value = "车主id")
    private Integer uid;

    /**
     * 标记位，1发布2未发布3过期
     */
    @ApiModelProperty(value = "标记位，1发布2未发布3过期")
    private Integer flag;

    private static final long serialVersionUID = 1L;
}


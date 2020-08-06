package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-CarConfig")
@Data
public class CarConfig implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 车型款式总述
     */
    @ApiModelProperty(value = "车型款式总述")
    private String style_description;

    /**
     * 厂商指导价格
     */
    @ApiModelProperty(value = "厂商指导价格")
    private Double guidance_price;

    /**
     * 车辆价格
     */
    @ApiModelProperty(value = "车辆价格")
    private Double car_price;

    /**
     * 补贴价格（只有新能源车有）
     */
    @ApiModelProperty(value = "补贴价格（只有新能源车有）")
    private Double subsidy_price;

    /**
     * 制造商（也是品牌）
     */
    @ApiModelProperty(value = "制造商（也是品牌）")
    private String manufacturer;

    /**
     * 国别（1中国2日系3韩系4美系5德系6欧系）
     */
    @ApiModelProperty(value = "国别（1中国2日系3韩系4美系5德系6欧系）")
    private Integer country;

    /**
     * 级别
     */
    @ApiModelProperty(value = "级别")
    private Integer model_level;

    /**
     * 能源类型（1汽油2柴油3油电混合4新能源）
     */
    @ApiModelProperty(value = "能源类型（1汽油2柴油3油电混合4新能源）")
    private Integer energy_type;

    /**
     * 环保标准（4国四5国五6国六）
     */
    @ApiModelProperty(value = "环保标准（4国四5国五6国六）")
    private Integer environmental_standard;

    /**
     * 上市时间（年.月）
     */
    @ApiModelProperty(value = "上市时间（年.月）")
    private Date ttm;

    /**
     * 最大功率（KW）
     */
    @ApiModelProperty(value = "最大功率（KW）")
    private Integer maximum_power;

    /**
     * 最大扭矩（单位：N.m）
     */
    @ApiModelProperty(value = "最大扭矩（单位：N.m）")
    private Integer maximum_torque;

    /**
     * 发动机型号
     */
    @ApiModelProperty(value = "发动机型号")
    private String engine_type;

    /**
     * 变速箱（1手动2手自一体3无级变速 4自动变速箱5其他）
     */
    @ApiModelProperty(value = "变速箱（1手动2手自一体3无级变速 4自动变速箱5其他）")
    private Integer gearshift_type;

    /**
     * 排量
     */
    @ApiModelProperty(value = "排量")
    private String displacement;

    /**
     * 长宽高（单位：mm）
     */
    @ApiModelProperty(value = "长宽高（单位：mm）")
    private String car_volume;

    /**
     * 车身结构
     */
    @ApiModelProperty(value = "车身结构")
    private String body_structure;

    /**
     * 最高车速
     */
    @ApiModelProperty(value = "最高车速")
    private Integer maximum_speed;

    /**
     * 官方百公里加速时间（单位：s）
     */
    @ApiModelProperty(value = "官方百公里加速时间（单位：s）")
    private Double acceleration_capability;

    /**
     * 工信部综合油耗（单位：L/100km）
     */
    @ApiModelProperty(value = "工信部综合油耗（单位：L/100km）")
    private Integer fuel_consumption;

    /**
     * 轴距
     */
    @ApiModelProperty(value = "轴距")
    private Integer wheel_base;

    /**
     * 油箱容积（单位：L）
     */
    @ApiModelProperty(value = "油箱容积（单位：L）")
    private Integer fuel_capacity;

    /**
     * 行李厢容积（单位：L）
     */
    @ApiModelProperty(value = "行李厢容积（单位：L）")
    private Integer trunk_capacity;

    /**
     * 安全装备
     */
    @ApiModelProperty(value = "安全装备")
    private String safety_equipment;

    /**
     * 辅助/操控配置
     */
    @ApiModelProperty(value = "辅助/操控配置")
    private String auxiliary_control;

    /**
     * 内部配置
     */
    @ApiModelProperty(value = "内部配置")
    private String interior_collocation;

    /**
     * 多媒体配置
     */
    @ApiModelProperty(value = "多媒体配置")
    private String media_collocation;

    private static final long serialVersionUID = 1L;
}


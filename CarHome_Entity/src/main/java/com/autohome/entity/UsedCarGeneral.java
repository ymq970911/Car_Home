package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
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
     * 车辆年审时间（年.月）
     */
    @ApiModelProperty(value = "车辆年审时间（年.月）")
    private String car_audit_time;

    /**
     * 交强险截至日期（年.月）
     */
    @ApiModelProperty(value = "交强险截至日期（年.月）")
    private String insurance_deadline_time;

    /**
     * 车使用税有效日期（年.月）
     */
    @ApiModelProperty(value = "车使用税有效日期（年.月）")
    private String car_tax_time;

    /**
     * 原厂保质（年.月）
     */
    @ApiModelProperty(value = "原厂保质（年.月）")
    private String rma_time;

    /**
     * 图片编号-外键
     */
    @ApiModelProperty(value = "汽车图片")
    private Integer img_id;


    private static final long serialVersionUID = 1L;
}


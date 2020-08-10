package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Garage")
@Data
public class Garage implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer gid;

    /**
     * 用户编号 - 外键
     */
    @ApiModelProperty(value = "用户编号 - 外键")
    private Integer uid;

    /**
     * 汽车品牌
     */
    @ApiModelProperty(value = "汽车品牌")
    private String brand;

    /**
     * 汽车款式
     */
    @ApiModelProperty(value = "汽车款式")
    private String style;

    /**
     * 图片编号-外键
     */
    @ApiModelProperty(value = "车库图片")
    private Integer img_id;


    private static final long serialVersionUID = 1L;
}


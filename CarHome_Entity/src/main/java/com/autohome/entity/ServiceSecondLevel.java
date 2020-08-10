package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.Data;

@ApiModel(value = "com-autohome-entity-ServiceSecondLevel")
@Data
public class ServiceSecondLevel implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer sid;

    /**
     * 二级服务名称
     */
    @ApiModelProperty(value = "二级服务名称")
    private String name;

    /**
     *
     */
    @ApiModelProperty(value = "一级服务编号 - 外键")
    private Integer fid;

    /**
     * 图片编号-外键
     */
    @ApiModelProperty(value = "服务图标")
    private Integer img_id;


    private static final long serialVersionUID = 1L;
}


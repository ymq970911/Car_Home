package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Forum")
@Data
public class Forum implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer forum_id;

    /**
     * 论坛名
     */
    @ApiModelProperty(value = "论坛名")
    private String forum_name;

    /**
     * 热门
     */
    @ApiModelProperty(value = "热门")
    private String tags;

    /**
     * 主题
     */
    @ApiModelProperty(value = "主题")
    private String theme;

    /**
     * 区域
     */
    @ApiModelProperty(value = "区域")
    private String area;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String care_series;

    private static final long serialVersionUID = 1L;
}


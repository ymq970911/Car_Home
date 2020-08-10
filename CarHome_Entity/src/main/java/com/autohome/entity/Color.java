package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Color")
@Data
public class Color implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 颜色名称
     */
    @ApiModelProperty(value = "颜色名称")
    private String color_name;

    private static final long serialVersionUID = 1L;
}


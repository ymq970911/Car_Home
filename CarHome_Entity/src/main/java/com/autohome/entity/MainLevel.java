package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-MainLevel")
@Data
public class MainLevel implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer lid;

    /**
     * 主分类名称
     */
    @ApiModelProperty(value = "主分类名称")
    private String name;

    private static final long serialVersionUID = 1L;
}


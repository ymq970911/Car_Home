package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-ServiceFirstLevel")
@Data
public class ServiceFirstLevel implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 一级服务名称
     */
    @ApiModelProperty(value = "一级服务名称")
    private String name;

    private static final long serialVersionUID = 1L;
}


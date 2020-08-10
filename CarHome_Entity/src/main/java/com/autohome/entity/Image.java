package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Image")
@Data
public class Image implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer iid;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String url;

    /**
     * 图片类型 - 外键
     */
    @ApiModelProperty(value = "图片类型 - 外键")
    private Integer type;


    private static final long serialVersionUID = 1L;
}


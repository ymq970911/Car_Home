package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-NewsLevel")
@Data
public class NewsLevel implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer nid;

    /**
     * 新闻分类名称
     */
    @ApiModelProperty(value = "新闻分类名称")
    private String name;

    private static final long serialVersionUID = 1L;
}


package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Collect")
@Data
public class Collect implements Serializable {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Integer clid;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer uid;

    /**
     * 新闻详情编号
     */
    @ApiModelProperty(value = "新闻详情编号")
    private Integer ndid;

    private static final long serialVersionUID = 1L;
}


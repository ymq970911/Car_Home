package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-BrandLevel")
@Data
public class BrandLevel implements Serializable {
    /**
     * 品牌编号
     */
    @ApiModelProperty(value = "品牌编号")
    private Integer bid;

    /**
     * 汽车品牌名称
     */
    @ApiModelProperty(value = "汽车品牌名称")
    private String name;

    /**
     * 分类编号-外键
     */
    @ApiModelProperty(value = "分类编号-外键")
    private Integer lid;

    private static final long serialVersionUID = 1L;
}


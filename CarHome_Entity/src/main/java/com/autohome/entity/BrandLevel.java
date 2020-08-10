package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

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

    /**
     * 图片编号-外键
     */
    @ApiModelProperty(value = "品牌logo")
    private Integer img_id;

    private static final long serialVersionUID = 1L;
}


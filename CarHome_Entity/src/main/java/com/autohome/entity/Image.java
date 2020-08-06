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
     * 用户编号 - 外键
     */
    @ApiModelProperty(value = "用户编号 - 外键")
    private Integer uid;

    /**
     * 汽车编号 - 外键
     */
    @ApiModelProperty(value = "汽车编号 - 外键")
    private Integer cid;

    /**
     * 新闻详情编号 - 外键
     */
    @ApiModelProperty(value = "新闻详情编号 - 外键")
    private Integer ndid;

    /**
     * 二手车编号 - 外键
     */
    @ApiModelProperty(value = "二手车编号 - 外键")
    private Integer used_car_id;

    /**
     * 用户车库图片编号 - 外键
     */
    @ApiModelProperty(value = "用户车库图片编号 - 外键")
    private Integer gid;

    private static final long serialVersionUID = 1L;
}


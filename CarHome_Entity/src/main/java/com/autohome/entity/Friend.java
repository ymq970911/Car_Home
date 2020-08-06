package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Friend")
@Data
public class Friend implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer fid;

    /**
     * 粉丝编号(用户) - 外键
     */
    @ApiModelProperty(value = "粉丝编号(用户) - 外键")
    private Integer fans_uid;

    /**
     * 关注编号(用户) - 外键
     */
    @ApiModelProperty(value = "关注编号(用户) - 外键")
    private Integer concern_uid;

    private static final long serialVersionUID = 1L;
}


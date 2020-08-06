package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-ForumFavorite")
@Data
public class ForumFavorite implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer favorite_id;

    /**
     * 关注论坛名字
     */
    @ApiModelProperty(value = "关注论坛名字")
    private String favorite_name;

    private static final long serialVersionUID = 1L;
}


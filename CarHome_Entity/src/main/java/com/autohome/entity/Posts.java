package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-Posts")
@Data
public class Posts implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer posts_id;

    /**
     * 帖子标题
     */
    @ApiModelProperty(value = "帖子标题")
    private String title;

    /**
     * 帖子内容
     */
    @ApiModelProperty(value = "帖子内容")
    private String content;

    /**
     * 帖子用户
     */
    @ApiModelProperty(value = "帖子用户")
    private String posts_user;

    /**
     * 发表时间
     */
    @ApiModelProperty(value = "发表时间")
    private Date post_time;

    /**
     * 论坛编号 - 外键
     */
    @ApiModelProperty(value = "论坛编号 - 外键")
    private Integer fid;

    private static final long serialVersionUID = 1L;
}


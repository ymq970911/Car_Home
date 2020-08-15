package com.autohome.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date post_time;

    /**
     * 论坛编号 - 外键
     */
    @ApiModelProperty(value = "论坛编号 - 外键")
    private Integer fid;

    private static final long serialVersionUID = 1L;
}


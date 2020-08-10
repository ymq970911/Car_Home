package com.autohome.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "com-autohome-entity-Comment")
@Data
public class Comment implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer cmid;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;

    /**
     * 评论作者
     */
    @ApiModelProperty(value = "评论作者")
    private String author;

    /**
     * 创建评论时间
     */
    @ApiModelProperty(value = "创建评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    /**
     * 当前评论楼层
     */
    @ApiModelProperty(value = "当前评论楼层")
    private Integer floor_num;

    /**
     * 用户编号 - 外键
     */
    @ApiModelProperty(value = "用户编号 - 外键")
    private Integer uid;

    private static final long serialVersionUID = 1L;
}


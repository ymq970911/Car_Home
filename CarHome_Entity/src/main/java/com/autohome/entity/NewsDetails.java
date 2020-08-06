package com.autohome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-autohome-entity-NewsDetails")
@Data
public class NewsDetails implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer ndid;

    /**
     * 新闻标题
     */
    @ApiModelProperty(value = "新闻标题")
    private String title;

    /**
     * 新闻作者
     */
    @ApiModelProperty(value = "新闻作者")
    private String author;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date ctime;

    /**
     * 新闻内容
     */
    @ApiModelProperty(value = "新闻内容")
    private String content;

    /**
     * 评论编号 - 外键
     */
    @ApiModelProperty(value = "评论编号 - 外键")
    private Integer comment_id;

    private static final long serialVersionUID = 1L;
}


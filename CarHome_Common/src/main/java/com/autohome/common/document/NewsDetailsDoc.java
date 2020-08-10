package com.autohome.common.document;

import lombok.Data;

import java.util.Date;

@Data
public class NewsDetailsDoc {

    private Integer ndid;

    private String title;

    private String author;

    private Date ctime;

    private String content;
}


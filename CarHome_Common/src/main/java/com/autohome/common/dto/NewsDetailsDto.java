package com.autohome.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewsDetailsDto implements Serializable {
    private String title;

    private String author;

    private String content;

    private Integer nid;

    private static final long serialVersionUID = 1L;
}


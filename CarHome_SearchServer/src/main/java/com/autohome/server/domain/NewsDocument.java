package com.autohome.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 16:25
 */
@Document(indexName = "car-es-index")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDocument {
    @Id
    private Integer ndid;
    private String title;
    private String author;
    private String content;
    private Integer nid;
}
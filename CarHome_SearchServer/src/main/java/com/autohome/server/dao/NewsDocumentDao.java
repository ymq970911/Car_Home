package com.autohome.server.dao;

import com.autohome.server.domain.NewsDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 16:27
 */
public interface NewsDocumentDao extends ElasticsearchRepository<NewsDocument,Integer>{
}

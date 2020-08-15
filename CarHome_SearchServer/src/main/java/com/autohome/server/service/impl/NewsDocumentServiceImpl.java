package com.autohome.server.service.impl;

import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;
import com.autohome.server.dao.NewsDocumentDao;
import com.autohome.server.dao.NewsSearchDao;
import com.autohome.server.domain.NewsDocument;
import com.autohome.server.service.NewsDocumentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 16:29
 */
@Service
public class NewsDocumentServiceImpl implements NewsDocumentService {
    @Autowired
    private NewsSearchDao dao;
    @Autowired
    private NewsDocumentDao documentDao;
    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Override
    public R saveBatch(List<NewsDocument> list) {
        documentDao.saveAll(list);
        return R.ok(null);
    }

    @Override
    public R queryPage(String msg, int p, int s) {
        try {
            //创建模糊查询对象
            WildcardQueryBuilder wildcardQuery = QueryBuilders.wildcardQuery("name", "*" + msg + "*");
            //实例化本地化查询构造器
            NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
            queryBuilder.withQuery(wildcardQuery);
            NativeSearchQuery query = queryBuilder.build();
            //设置分页和排序
            PageRequest pageRequest = PageRequest.of(p, s, Sort.by(Sort.Order.desc("id")));
            query.setPageable(pageRequest);
            //发送查询 并获取查询结果
            SearchHits<NewsDocument> searchHits = restTemplate.search(query, NewsDocument.class, IndexCoordinates.of("car-es-index"));
            //遍历获取查结果
            List<NewsDocument> list = new ArrayList<>();
            List<SearchHit<NewsDocument>> searchHitList = searchHits.getSearchHits();
            for (int i = 0; i < searchHitList.size(); i++) {
                list.add(searchHitList.get(i).getContent());
            }
            //return LayuiPage.createPageInfo(list, searchHits.getTotalHits());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*分页*/
        PageHelper.startPage(1, 2);
        return R.ok(new PageInfo<>(dao.searchByKeywords(msg)));
    }

    @Override
    public R all() {
        return R.ok(documentDao.findAll());
    }

    @Override
    public R delAll() {
        documentDao.deleteAll();
        return R.ok("OK");
    }

}

package com.autohome.api.service.impl;

import com.autohome.api.service.SearchService;
import com.autohome.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: SearchServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/10 21:21
 */
@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R queryPage(String msg, int page, int limit) {
        return restTemplate.getForObject("http://search/server/search.do?msg=" + msg + "&page=" + page + "&limit=" + limit, R.class);
    }
}

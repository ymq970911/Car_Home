package com.autohome.api.service.impl;

import com.autohome.api.service.NewsService;
import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: NewsServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 15:18
 */
@Service
@Slf4j
public class NewsServiceImpl implements NewsService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R addNews(NewsDetailsDto dto) {
        log.info(dto.toString());
        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NewsDetailsDto> requestEntity = new HttpEntity<>(dto, requestHeaders);
        return restTemplate.postForObject("http://server/server/news/add.do", requestEntity, R.class);
    }

    @Override
    public R delNews(Integer id) {
        return restTemplate.getForObject("", R.class);
    }

    @Override
    public R updateNews(NewsDetailsDto dto) {
        return restTemplate.postForObject("", dto, R.class);
    }

    @Override
    public R getAllNewss(Integer pageNum, Integer pageSize) {
        return restTemplate.getForObject("http://server/server/news/all.do", R.class);
    }

    @Override
    public R getNewsById(Integer id) {
        return restTemplate.getForObject("", R.class);
    }

    @Override
    public R getNewsByPage(Integer pageNum, Integer pageSize, Integer newsType) {
        return restTemplate.getForObject("", R.class);
    }
}

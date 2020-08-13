package com.autohome.api.service.impl;

import com.autohome.api.service.CarLevelService;
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
 * @Class: CarLevelServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/07 15:02
 */
@Service
@Slf4j
public class CarLevelServiceImpl implements CarLevelService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R addLevel(String name) {
        return restTemplate.getForObject("http://server/server/carlevel/addLevel.do?name=" + name, R.class);
    }

    @Override
    public R delLevel(Integer id) {
        return restTemplate.getForObject("http://server/server/carlevel/delLevel.do?id=" + id, R.class);
    }

    @Override
    public R updateLevel(MainLevel mainLevel) {
        log.info(mainLevel.toString());

        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MainLevel> requestEntity = new HttpEntity<>(mainLevel, requestHeaders);
        return restTemplate.postForObject("http://server/server/carlevel/update.do", requestEntity, R.class);
    }

    @Override
    public R getAllLevels() {
        return restTemplate.getForObject("http://server/server/carlevel/allLevels.do", R.class);
    }

    @Override
    public R getLevelById(Integer id) {
        return restTemplate.getForObject("http://server/server/carlevel/oneLevel.do?id=" + id, R.class);
    }
}

package com.autohome.api.service.impl;

import com.autohome.api.service.CarServiceService;
import com.autohome.common.dto.ServiceFirstLevelDto;
import com.autohome.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: CarServiceServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 10:11
 */
@Service
@Slf4j
public class CarServiceServiceImpl implements CarServiceService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R addService(String name) {
        return restTemplate.getForObject("http://server/server/carservice/addService.do?name=" + name, R.class);
    }

    @Override
    public R delService(Integer id) {
        return restTemplate.getForObject("http://server/server/carservice/delService.do?id=" + id, R.class);
    }

    @Override
    public R updateService(ServiceFirstLevelDto dto) {
        log.info(dto.toString());

        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ServiceFirstLevelDto> requestEntity = new HttpEntity<>(dto, requestHeaders);
        return restTemplate.postForObject("http://server/server/carservice/update.do", requestEntity, R.class);
    }

    @Override
    public R getAllServices() {
        return restTemplate.getForObject("http://server/server/carservice/allServices.do", R.class);
    }

    @Override
    public R getServiceById(Integer id) {
        return restTemplate.getForObject("http://server/server/carservice/oneService/" + id, R.class);
    }
}

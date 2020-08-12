package com.autohome.api.service.impl;

import com.autohome.api.service.UsedCarConfigService;
import com.autohome.common.dto.LicencePlateDto;
import com.autohome.common.jsonpojo.LicencePlate;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-12 15:22
 **/

@Service
public class UsedCarConfigServiceImpl implements UsedCarConfigService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R insertUsedCarConfig(@PathVariable Integer cid, @PathVariable Integer uid, @RequestBody LicencePlate licence) {
        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LicencePlate> requestEntity = new HttpEntity<>(licence, requestHeaders);

        return restTemplate.postForObject("http://usedcar/server/usedcar/config/add.do/{cid}/{uid}", requestEntity, R.class, cid, uid);
    }

    @Override
    public R deleteUsedCarConfig(@PathVariable Integer cid, @PathVariable Integer uid, @PathVariable Integer uniqueId) {
        return restTemplate.postForObject("http://usedcar/server/usedcar/config/del.do/{cid}/{uid}/{uniqueId}", null, R.class, cid, uid, uniqueId);
    }

    @Override
    public R updateLicencePlate(@RequestBody LicencePlateDto licencePlateDto) {
        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LicencePlateDto> requestEntity = new HttpEntity<>(licencePlateDto, requestHeaders);
        return restTemplate.postForObject("http://usedcar/server/usedcar/config/update.do", requestEntity, R.class);
    }

    @Override
    public R getUsedCarConfig(@PathVariable Integer cid, @PathVariable Integer uid) {
        return restTemplate.getForObject("http://usedcar/server/usedcar/config/getdetail.do/{uid}/{cid}", R.class, cid, uid);
    }

    @Override
    public R getUsedCarConfig(@PathVariable Integer uid) {
        return restTemplate.getForObject("http://usedcar/server/usedcar/config/getdetail.do/{uid}", R.class, uid);
    }
}

package com.autohome.api.service.impl;

import com.autohome.api.service.UsedCarService;
import com.autohome.common.dto.UsedCarGeneralDto;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-11 20:56
 **/

@Service
public class UsedCarServiceImpl implements UsedCarService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R deleteUsedCarBySystem(@PathVariable Integer uniqueId) {
        return restTemplate.postForObject("http://usedcar/server/usedcar/general/sysdel.do/{uniqueId}", null, R.class, uniqueId);
    }

    @Override
    public R deleteUsedCarByUser(@PathVariable Integer uid, @PathVariable Integer cid, @PathVariable Integer uniqueId) {
        return restTemplate.postForObject("http://usedcar/server/usedcar/general/userdel.do/{uid}/{cid}/{uniqueId}", null, R.class, uid, cid, uniqueId);
    }

    @Override
    public R updateUsedCarByUser(@RequestBody UsedCarGeneralDto usedCarGeneralDto) {
        // 解决415问题，配置消费者发送到提供者的HTTP消息头为 JSON，告诉服务提供者以 JSON 格式解析数据
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UsedCarGeneralDto> requestEntity = new HttpEntity<>(usedCarGeneralDto, requestHeaders);
        return restTemplate.postForObject("http://usedcar/server/usedcar/general/update.do", requestEntity, R.class);
    }

    @Override
    public R getAllUsedCar() {
        return restTemplate.getForObject("http://usedcar/server/usedcar/general/getall.do", R.class);
    }

    @Override
    public R updateUsedCarFlag(@PathVariable Integer cid, @PathVariable Integer uid, @PathVariable Integer uniqueId) {
        return restTemplate.postForObject("http://usedcar/server/usedcar/general/publish.do/{uid}/{cid}/{uniqueId}", null, R.class, uid, cid, uniqueId);
    }

    @Override
    public R getUserUsedCar(@PathVariable Integer uid) {
        return restTemplate.getForObject("http://usedcar/server/usedcar/general/getuser.do/{uid}", R.class, uid);
    }

    @Override
    public R getUserUsedCar(@PathVariable Integer uid, @PathVariable(required = false) Integer cid) {
        return restTemplate.getForObject("http://usedcar/server/usedcar/general/getuser.do/{uid}/{cid}", R.class, uid, cid);
    }

    @Override
    public R getUserUsedCar(@PathVariable Integer uid, @PathVariable(required = false) Integer cid, @PathVariable(required = false) Integer uniqueId) {
        return restTemplate.getForObject("http://usedcar/server/usedcar/general/getuser.do/{uid}/{cid}/{uniqueId}", R.class, uid, cid, uniqueId);
    }

}

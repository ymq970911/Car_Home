package com.autohome.server.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.autohome.common.dto.*;
import com.autohome.common.util.StringUtil;
import com.autohome.common.vo.R;
import com.autohome.server.dao.BrandLevelDao;
import com.autohome.server.service.BrandLeveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.autohome.common.constant.SystemConstant.CAR_LIST_KEY;

/**
 * @author YMQ
 */
@Service
@Slf4j
public class BrandLeveServiceImpl implements BrandLeveService {

    @Autowired
    private BrandLevelDao dao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R getAllBrandLevDto() {
        List<BrandLevDto> allCarGeneral = dao.getAllBrandLevDto();
        System.out.println(allCarGeneral);
        if (allCarGeneral != null) {
            return R.ok(JSON.toJSONString(allCarGeneral));
        } else {
            return R.fail("查询失败");
        }

    }

    @Override
    public R getCarByBrandId(Integer bid) {
        List<GetCarByBrandIdDto> carByBrandId = dao.getCarByBrandId(bid);
        if (carByBrandId != null && carByBrandId.size() > 0) {
            return R.ok(carByBrandId);
        } else {
            return R.fail("查询失败");
        }

    }


    @Override
    public R GetBrandById(Integer bid) {
        //查品牌logo 名字
        System.out.println(bid);
        BrandLevDto brandById = dao.getBrandById(bid);
        log.info(String.valueOf(brandById));
        if (brandById != null && !brandById.equals("")) {
            return R.ok(brandById);
        } else {
            return R.fail("查询失败");
        }

    }

    @Override
    public R getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid) {
        List<GetCarDto> getCarDtos = dao.getBrandIdAndModelLevelAndType(type, model_level, bid);

        if (getCarDtos != null && getCarDtos.size() > 0) {
            return R.ok(getCarDtos);
        } else {
            return R.fail("查詢失敗");
        }
    }

    @Override
    public R leaderboard(Integer bid) {
        String key = CAR_LIST_KEY; //"car:hot:zset"

        // 判断 Cache 中是否存在数据
        R checkKey = restTemplate.getForObject("http://cacheserver/cache/api/checkkey.do?key=" + key, R.class);
        if (checkKey != null && checkKey.getCode() == 200) {
            if ("false".equals(checkKey.getData())) {

                // Cache 中未存储 或 key已过期，则需要从数据库中读取一次 --> 即 上线前的数据预热
                List<CarDto> carAttention = dao.getCarAttention();
                if (carAttention != null) {
                    //遍历存入redis
                    for (CarDto dto : carAttention) {

                        // 添加到 redis 有序集合 zset
                        ZsetDto zset = new ZsetDto();
                        zset.setKey(key);
                        zset.setTimes(60 * 60 * 24L);
                        zset.setScore(dto.getAttention().doubleValue());
                        zset.setValue(JSON.toJSONString(dto));

                        HttpHeaders requestHeaders = new HttpHeaders();
                        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                        HttpEntity<ZsetDto> requestEntity = new HttpEntity<>(zset, requestHeaders);
                        restTemplate.postForObject("http://cacheserver/cache/api/savezset.do", requestEntity, R.class);
                    }

                    R r = restTemplate.getForObject("http://cacheserver/cache/api/getzset.do?key=" + key + "&flag=" + 1, R.class);
                    if (r != null) {
                        return R.ok(r.getData());
                    }
                }
            }
        }
        return R.fail("排序失败");
    }
}
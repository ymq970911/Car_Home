package com.autohome.server.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.autohome.common.dto.*;
import com.autohome.common.vo.R;
import com.autohome.server.ZsetDto;
import com.autohome.server.dao.BrandLevelDao;
import com.autohome.server.service.BrandLeveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Key;
import java.util.*;

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
        //判断redis是否存在数据

        List<CarDto> carAttention = dao.getCarAttention();
        String key = "car:hot:zset";
        if (carAttention != null) {
            //遍历存入redis
            for (CarDto dto : carAttention) {
                //添加到有序集合
//                     redisTemplate.opsForZSet().add("car:hot:zset",JSON.toJSONString(dto), dto.getAttention());
                //cacheService.saveScoreSet2Redis("car:hot:zset", -1L, dto.getAttention(), JSON.toJSONString(dto));

                ZsetDto z = new ZsetDto();
                z.setKey(key);
                z.setTimes(60 * 60 * 24L);
                z.setScore(dto.getAttention().doubleValue());
                z.setValue(JSON.toJSONString(dto));
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<ZsetDto> requestEntity = new HttpEntity<>(z, requestHeaders);
                restTemplate.postForObject("http://cacheserver/cache/api/savezset.do", requestEntity, R.class);
            }
            R r = restTemplate.getForObject("http://cacheserver/cache/api/getzset.do?key=" + key + "&flag=" + 1, R.class);

            //Map map = JSON.parseObject(r.getData().toString(), Map.class);
          //  SortedMap<String, Double> map = JSONObject.parseObject(r.getData().toString(), TreeMap.class, Feature.OrderedField);
         LinkedHashMap<CarDto, Double> json = JSONObject.parseObject(r.getData().toString(), LinkedHashMap.class, Feature.OrderedField);
         //   List<String> list = JSON.parseObject(r.getData().toString(),ArrayList.class);

            return R.ok(JSONObject.toJSONString(json));

        }
        return R.fail("排序失败");
    }

    //查询关注排行榜所有车辆的信息
    @Override
    public R getCarAttention() {
        List<CarDto> carAttention = dao.getCarAttention();
        if (carAttention != null && carAttention.size() > 0) {
            return R.ok(carAttention);
        } else {
            return R.fail("查询失败");
        }
    }

    //添加关注度
    @Override
    public R updateCarAttention(UpdateOrAddCarAttention updateOrAddCarAttention) {
        int i = dao.updateCarAttention(updateOrAddCarAttention);
        if (i > 0) {
            return R.ok("添加关注成功");
        } else {
            return R.fail("添加关注失败");
        }
    }

    //查询关注度
    @Override
    public R getCarAttentionById(Integer id) {
        UpdateOrAddCarAttention carAttentionById = dao.getCarAttentionById(id);
        if (carAttentionById != null && !carAttentionById.equals("")) {
            return R.ok(carAttentionById);
        } else {
            return R.fail("查询热度失败");
        }
    }

}
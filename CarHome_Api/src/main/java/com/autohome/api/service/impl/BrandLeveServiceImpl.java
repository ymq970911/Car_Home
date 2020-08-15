package com.autohome.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.autohome.api.service.BrandLeveService;
import com.autohome.common.dto.CarDto;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.*;

/**
 * @author YMQ
 */
@Service
public class BrandLeveServiceImpl implements BrandLeveService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R getAllBrandLevel() {

        R r = restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getAllBrandLevel.do", R.class);
        return R.ok(JSON.parseObject(r.getData().toString(), List.class));
    }

    @Override
    public R GetBrandById(@PathVariable Integer bid) {
        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/GetBrandById.do?bid=" + bid, R.class);
    }

    @Override
    public R getBrandIdAndModelLevelAndType(@RequestParam Integer type, @RequestParam String model_level, @RequestParam Integer bid) {
        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getbrandidandmodellevelAndtype.do?type=" + type + "&model_level=" + model_level + "&bid=" + bid, R.class);
    }

    @Override
    public R getCarByBrandId(Integer bid) {
        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getcarbybrandid.do?bid=" + bid, R.class);
    }

    @Override
    public R leaderboard(Integer bid) {
        R r = restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/leaderboard.do?bid=" + bid, R.class);
        List list = null;
        if (r != null) {
            // String 中在传入前即是有序的，因此只需要按 Feature.OrderedField 有序模式解析即可
            list = JSONObject.parseObject(r.getData().toString(), List.class, Feature.OrderedField);
        }
        return R.ok(list);
    }
}

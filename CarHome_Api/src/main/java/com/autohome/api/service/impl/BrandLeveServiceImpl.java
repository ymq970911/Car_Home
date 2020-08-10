package com.autohome.api.service.impl;

import com.autohome.api.service.BrandLeveService;
import com.autohome.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author YMQ
 */
@Service
public class BrandLeveServiceImpl implements BrandLeveService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R getAllBrandLevel() {

        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getallbrandlevel.do", R.class);
    }

    @Override
    public R GetBrandById(Integer bid) {
        System.out.println(bid);
        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getbrandbyId.do?bid=" + bid, R.class);
    }

    @Override
    public R getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid) {
        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getbrandidandmodellevelAndtype.do/?type="+type+"&model_level="+model_level+"&bid="+bid, R.class);
    }

    @Override
    public R getCarByBrandId(Integer bid) {
        return restTemplate.getForObject("http://carserver/carserver/brandlevecontroller/getcarbybrandid.do/?bid="+bid, R.class);
    }
}

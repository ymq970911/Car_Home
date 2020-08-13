package com.autohome.server.service.impl;


import com.autohome.common.dto.BrandLevDto;
import com.autohome.common.dto.GetCarByBrandIdDto;
import com.autohome.common.dto.GetCarDto;
import com.autohome.common.vo.R;
import com.autohome.server.dao.BrandLevelDao;
import com.autohome.server.service.BrandLeveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YMQ
 */
@Service
@Slf4j
public class BrandLeveServiceImpl implements BrandLeveService {
    @Autowired
    private BrandLevelDao dao;

    @Override
    public R getAllBrandLevel() {
        List<BrandLevDto> allCarGeneral = dao.getAllBrandLevDto();
        if (allCarGeneral != null) {
            return R.ok(allCarGeneral);
        } else {
            return R.fail("查询失败");
        }

    }

    @Override
    public R getCarByBrandId(Integer bid) {
        List<GetCarByBrandIdDto> carByBrandId = dao.getCarByBrandId(bid);
        if (carByBrandId!=null && carByBrandId.size()>0){
            return R.ok(carByBrandId);
        }else {
            return R.fail("查询失败");
        }

    }

    @Override
    public R getBrandById(Integer bid) {
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
        if (getCarDtos!=null && getCarDtos.size()>0){
            return R.ok(getCarDtos);
        }else {
            return R.fail("查詢失敗");
        }
    }

}
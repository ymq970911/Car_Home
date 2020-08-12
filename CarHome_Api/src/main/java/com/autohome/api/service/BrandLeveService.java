package com.autohome.api.service;

import com.autohome.common.vo.R;

/**
 * @author YMQ
 */
public interface BrandLeveService {
    R getAllBrandLevel();

    R GetBrandById(Integer bid);

    R getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid);

    R getCarByBrandId(Integer bid);
}

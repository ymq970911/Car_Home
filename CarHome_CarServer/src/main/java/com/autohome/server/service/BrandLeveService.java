package com.autohome.server.service;

import com.autohome.common.dto.BrandLevDto;
import com.autohome.common.dto.GetCarByBrandIdDto;
import com.autohome.common.dto.GetCarDto;
import com.autohome.common.vo.R;

import java.util.List;

/**
 * @author YMQ
 */

public interface BrandLeveService {
    /**
     * @return BrandLevDto
     */
    R getAllBrandLevel();

    /**
     * @param bid
     * @return GetCarByBrandIdDto
     */
    R getCarByBrandId(Integer bid);

    /**
     * @param bid
     * @return BrandLevDto
     */
    R  getBrandById(Integer bid);

    /**
     * @param type
     * @param model_level
     * @param bid
     * @return GetCarDto
     */
    R getBrandIdAndModelLevelAndType(Integer type, String model_level,Integer bid);

}

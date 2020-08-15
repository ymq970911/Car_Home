package com.autohome.server.service;

import com.autohome.common.dto.*;
import com.autohome.common.vo.R;

import java.util.List;

/**
 * @author YMQ
 */

public interface BrandLeveService {

    R getAllBrandLevDto();

    R getCarByBrandId(Integer bid);

    R GetBrandById(Integer bid);

    R getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid);

    R leaderboard(Integer bid);
}

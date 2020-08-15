package com.autohome.server.service;

import com.autohome.common.dto.*;
import com.autohome.common.vo.R;

import java.util.List;

/**
 * @author YMQ
 */

public interface BrandLeveService {
    /**
     * @return BrandLevDto
     */
    R getAllBrandLevDto();

    /**
     * @param bid
     * @return GetCarByBrandIdDto
     */
    R getCarByBrandId(Integer bid);

    /**
     * @param bid
     * @return BrandLevDto
     */
    R  GetBrandById(Integer bid);

    /**
     * @param type
     * @param model_level
     * @param bid
     * @return GetCarDto
     */
    R getBrandIdAndModelLevelAndType(Integer type, String model_level,Integer bid);


    /**
     * @param type
     * @param model_level
     * @param bid
     * @return
     * 排行榜
     */
    R leaderboard(Integer bid);

   R getCarAttention();

    /**
     * @param updateOrAddCarAttention
     * @return
     * 添加某车的关注度
     */
    R updateCarAttention(UpdateOrAddCarAttention updateOrAddCarAttention);

    /**
     * @param id
     * @return
     */
    R getCarAttentionById(Integer id);

}

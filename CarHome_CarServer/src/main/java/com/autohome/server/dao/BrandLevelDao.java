package com.autohome.server.dao;

import com.autohome.common.dto.*;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YMQ
 */
@Repository
public interface BrandLevelDao {
    /**
     * 按照首字母查詢所有車輛
     * @return
     */
    List<BrandLevDto> getAllBrandLevDto();

    /**
     * @param bid
     * @return
     * 通過id查找品牌信息
     */
    BrandLevDto getBrandById(Integer bid);

    /**
     * @param bid
     * @return
     * 通過bid查找品牌下全部車輛信息
     */
    List<GetCarByBrandIdDto> getCarByBrandId(Integer bid);
    /**
     * @param type
     * @param model_level
     * @param bid
     * @return
     * 根據類型和型號查找不同型號的車量信息
     */
    List<GetCarDto> getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid);

    List<CarDto> getCarAttention();

    /**
     * @param updateOrAddCarAttention
     * @return
     * 添加某车的关注度
     */
    int updateCarAttention(UpdateOrAddCarAttention updateOrAddCarAttention);

    /**
     * @param id
     * @return
     */
    UpdateOrAddCarAttention getCarAttentionById(Integer id);
}

package com.autohome.server.dao;

import com.autohome.common.dto.*;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YMQ
 */
@Repository
public interface BrandLevelDao {

    List<BrandLevDto> getAllBrandLevDto();

    BrandLevDto getBrandById(Integer bid);

    List<GetCarByBrandIdDto> getCarByBrandId(Integer bid);

    List<GetCarDto> getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid);

    List<CarDto> getCarAttention();
}

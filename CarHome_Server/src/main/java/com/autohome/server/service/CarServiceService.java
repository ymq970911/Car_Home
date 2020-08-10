package com.autohome.server.service;

import com.autohome.common.dto.ServiceFirstLevelDto;
import com.autohome.common.vo.R;

/**
 * @Interface: CarServiceService
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 10:11
 */

public interface CarServiceService {
    R addService(String name);

    R delService(Integer id);

    R updateService(ServiceFirstLevelDto dto);

    R getAllServices();

    R getServiceById(Integer id);
}

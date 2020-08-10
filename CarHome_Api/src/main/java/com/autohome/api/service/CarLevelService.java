package com.autohome.api.service;

import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;

/**
 * @Interface: CarLevelService
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/07 15:00
 */
public interface CarLevelService {
    R addLevel(String name);

    R delLevel(Integer id);

    R updateLevel(MainLevel mainLevel);

    R getAllLevels();

    R getLevelById(Integer id);
}

package com.autohome.api.service;

import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;

/**
 * @Interface: CarLevelService
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/07 15:00
 */
//@FeignClient("server")
public interface CarLevelService {

    //@GetMapping(value = "server/server/carlevel/addLevel/{name}")
    R addLevel(String name);

    //@GetMapping(value = "server/server/carlevel/delLevel/{id}")
    R delLevel(Integer id);

    //@PostMapping(value = "server/server/carlevel/update.do")
    R updateLevel(MainLevel mainLevel);

    //@GetMapping(value = "server/server/carlevel/allLevels.do")
    R getAllLevels();
}

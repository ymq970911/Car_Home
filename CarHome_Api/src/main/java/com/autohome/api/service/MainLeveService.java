package com.autohome.api.service;

import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;

/**
 * @author YMQ
 */

public interface MainLeveService {
    R getAllMainLevel();

    R addMainLevel(String name);
}

package com.autohome.server.service;

import com.autohome.common.vo.R;

/**
 * @author YMQ
 */

public interface MainLeveService {
    R getAllMainLevel();
    R addMainLevel(String name);
}

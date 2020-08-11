package com.autohome.api.service;

import com.autohome.common.vo.R;

/**
 * @Interface: SearchService
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/10 21:18
 */

public interface SearchService {
    R queryPage(String msg, int page, int limit);
}

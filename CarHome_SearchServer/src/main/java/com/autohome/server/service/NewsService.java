package com.autohome.server.service;

import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 11:41
 */
public interface NewsService {
    R importData(NewsDetailsDto dto);
}

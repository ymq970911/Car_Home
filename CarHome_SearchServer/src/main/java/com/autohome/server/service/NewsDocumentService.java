package com.autohome.server.service;

import com.autohome.common.vo.R;
import com.autohome.server.domain.NewsDocument;

import java.util.List;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 16:28
 */
public interface NewsDocumentService {
    //批量新增
    R saveBatch(List<NewsDocument> list);
    //搜索
    R queryPage(String msg, int p, int s);
    R all();
    R delAll();
}

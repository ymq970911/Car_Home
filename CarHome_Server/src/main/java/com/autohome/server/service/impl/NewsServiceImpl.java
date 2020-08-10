package com.autohome.server.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.util.BeanUtil;
import com.autohome.common.vo.R;
import com.autohome.entity.NewsDetails;
import com.autohome.server.dao.NewsDao;
import com.autohome.server.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class: NewsServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 15:18
 */
@Service
@Slf4j
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao dao;

    @Override
    public R addNews(NewsDetailsDto dto) {
        if (!StringUtils.isEmpty(dto.getTitle()) && !StringUtils.isEmpty(dto.getAuthor()) && !StringUtils.isEmpty(dto.getContent())) {
            NewsDetails newsDetails = BeanUtil.copyDto(NewsDetails.class, dto);
            if (dao.save(newsDetails) > 0) {
                // 添加成功，记录日志
                log.info(dto.toString());
                return R.ok();
            }
        }
        return R.fail("添加失败");
    }

    @Override
    public R delNews(Integer id) {
        return null;
    }

    @Override
    public R updateNews(NewsDetailsDto dto) {
        return null;
    }

    @Override
    public R getAllNewss(Integer pageNum, Integer pageSize) {
        return R.ok(dao.getAllByPage(pageNum, pageSize));
    }

    @Override
    public R getNewsById(Integer id) {
        return null;
    }

    @Override
    public R getNewsByPage(Integer pageNum, Integer pageSize, Integer newsType) {
        return null;
    }
}

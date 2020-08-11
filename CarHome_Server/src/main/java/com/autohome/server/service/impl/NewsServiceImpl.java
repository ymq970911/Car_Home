package com.autohome.server.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.dto.NewsDetailsIdDto;
import com.autohome.common.util.BeanUtil;
import com.autohome.common.vo.R;
import com.autohome.entity.NewsDetails;
import com.autohome.server.dao.NewsDao;
import com.autohome.server.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            if (dao.save(dto) > 0) {
                // 添加成功，记录日志
                log.info(dto.toString());
                return R.ok();
            }
        }
        return R.fail("添加失败");
    }

    @Override
    public R delNews(Integer id) {
        if (null != dao.getOneById(id)) {
            if (dao.delete(id) > 0) {
                return R.ok();
            }
        }
        return R.fail("删除失败");
    }

    @Override
    public R updateNews(NewsDetailsIdDto dto) {
        if (!StringUtils.isEmpty(dto.getTitle()) && !StringUtils.isEmpty(dto.getAuthor()) && !StringUtils.isEmpty(dto.getContent())) {
            if (null != dao.getOneById(dto.getNdid())) {
                if (dao.update(dto) > 0) {
                    return R.ok();
                }
            }
        }
        return R.fail("参数有误或修改失败");
    }

    @Override
    public R getAllNewss(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return R.ok(new PageInfo<>(dao.getAllByPage()));
    }

    @Override
    public R getNewsById(Integer id) {
        return R.ok(dao.getOneById(id));
    }

    @Override
    public R getNewsByPage(Integer pageNum, Integer pageSize, Integer newsType) {
        PageHelper.startPage(pageNum, pageSize);
        return R.ok(new PageInfo<>(dao.getAllByTypeAndPage(newsType)));
    }
}

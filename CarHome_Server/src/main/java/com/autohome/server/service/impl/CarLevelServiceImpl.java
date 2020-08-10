package com.autohome.server.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import com.autohome.server.dao.CarLevelDao;
import com.autohome.server.service.CarLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class: CarLevelServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/07 15:02
 */
@Service
@Slf4j
public class CarLevelServiceImpl implements CarLevelService {

    @Autowired
    private CarLevelDao dao;

    @Override
    public R addLevel(String levelName) {
        if (!StringUtils.isEmpty(levelName)) {
            log.info("插入主分类：" + levelName);
            if (dao.save(levelName) > 0) {
                return R.ok();
            }
        }
        return R.fail("参数有误或新增失败");
    }

    @Override
    public R delLevel(Integer id) {
        if (null != dao.selectOne(id)) {
            if (dao.delete(id) > 0) {
                log.info("删除主分类：" + id);
                return R.ok();
            }
        }
        return R.fail("参数有误或删除失败");
    }

    @Override
    public R updateLevel(MainLevel mainLevel) {
        Integer id = mainLevel.getLid();
        if (null != dao.selectOne(id)) {
            if (dao.update(mainLevel) > 0) {
                log.info("修改主分类：" + id);
                return R.ok();
            }
        }
        return R.fail("参数有误或修改失败");
    }

    @Override
    public R getAllLevels() {
        return R.ok(dao.selectAll());
    }

    @Override
    public R getLevelById(Integer id) {
        return R.ok(dao.selectOne(id));
    }
}

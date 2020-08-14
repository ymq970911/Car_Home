package com.autohome.server.service;

import com.aliyuncs.utils.StringUtils;
import com.autohome.common.dto.ServiceFirstLevelDto;
import com.autohome.common.vo.R;
import com.autohome.server.dao.CarServiceDao;
import com.autohome.server.service.CarServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class: CarServiceServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 10:11
 */
@Service
@Slf4j
public class CarServiceServiceImpl implements CarServiceService {

    @Autowired
    private CarServiceDao dao;

    @Override
    public R addService(String name) {
        if (!StringUtils.isEmpty(name)) {
            if (dao.save(name) > 0) {
                return R.ok();
            }
        }
        return R.fail("参数有误或新增失败");
    }

    @Override
    public R delService(Integer id) {
        if (null != dao.selectOne(id)) {
            if (dao.delete(id) > 0) {
                return R.ok();
            }
        }
        return R.fail("参数有误或删除失败");
    }

    @Override
    public R updateService(ServiceFirstLevelDto dto) {
        if (null != dao.selectOne(dto.getId())) {
            if (dao.update(dto) > 0) {
                return R.ok();
            }
        }
        return R.fail("参数有误或修改失败");
    }

    @Override
    public R getAllServices() {
        return R.ok(dao.selectAll());
    }

    @Override
    public R getServiceById(Integer id) {
        return R.ok(dao.selectOne(id));
    }
}

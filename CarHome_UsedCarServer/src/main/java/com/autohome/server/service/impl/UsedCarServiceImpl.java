package com.autohome.server.service.impl;

import com.autohome.common.vo.R;
import com.autohome.entity.UsedCarGeneral;
import com.autohome.server.dao.UsedCarConfigDao;
import com.autohome.server.dao.UsedCarDao;
import com.autohome.common.dto.UsedCarGeneralDto;
import com.autohome.server.service.UsedCarService;
import com.autohome.server.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Tainted;
import java.util.List;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-10 01:58
 **/

@Service
public class UsedCarServiceImpl implements UsedCarService {
    @Autowired
    private UsedCarDao usedCarDao;

    @Autowired
    private UsedCarConfigDao usedCarConfigDao;


    @Override
    public R insertUsedCar(UsedCarGeneralDto usedCarGeneralDto) {
        return null;
    }

    @Override
    public R deleteUsedCarBySystem(Integer uniqueId) {
        if (usedCarDao.deleteUsedCarBySystem(uniqueId) > 0) {
            return R.ok();
        }
        return R.fail("失败");
    }

    @Override
    public R deleteUsedCarByUser(Integer uid, Integer cid, Integer uniqueId) {
        String checked = CheckUtil.paramChecking(cid, uid, uniqueId);
        if (!checked.equals("ok")) {
            return R.fail(checked);
        } else {
            int result = usedCarDao.deleteUsedCarByUser(uid, cid, uniqueId);
            if (result > 0) {
                return R.ok();
            }
            return R.fail("修改失败！");
        }
    }

    @Transactional
    @Override
    public R updateUsedCarByUser(UsedCarGeneralDto usedCarGeneralDto) {
        Integer cid = usedCarGeneralDto.getCid();
        Integer uid = usedCarGeneralDto.getUid();
        Integer uniqueId = usedCarGeneralDto.getUniqueId();
        String checked = CheckUtil.paramChecking(cid, uid, uniqueId);

        if (checked.equals("ok")) {
            // 为了几种查询集中到一个里面。
            // 虽然List接收，但是仅有一条数据
            List<UsedCarGeneral> list = usedCarDao.getAllUserUsedCar(uid, cid, uniqueId);
            UsedCarGeneral car;
            if (list.size() > 0) {
                car = list.get(0);
            } else {
                return R.fail("没有该汽车！");
            }
            if (usedCarGeneralDto.getStyle_description().equals("")) {
                usedCarGeneralDto.setStyle_description(car.getStyle_description());
            }
            if (usedCarGeneralDto.getCar_price().equals("")) {
                usedCarGeneralDto.setCar_price(car.getCar_price());
            }
            if (usedCarGeneralDto.getCar_registration_time().equals("")) {
                usedCarGeneralDto.setCar_registration_time(car.getCar_registration_time());
            }
            if (usedCarGeneralDto.getPerformance_mileage() == 0d) {
                usedCarGeneralDto.setPerformance_mileage(car.getPerformance_mileage());
            }
            if (usedCarGeneralDto.getChange_number() == 0) {
                usedCarGeneralDto.setChange_number(car.getChange_number());
            }
            if (usedCarGeneralDto.getLicense_location().equals("")) {
                usedCarGeneralDto.setLicense_location(car.getLicense_location());
            }
            if (usedCarGeneralDto.getMeeting_place().equals("")) {
                usedCarGeneralDto.setMeeting_place(car.getMeeting_place());
            }
            int result = usedCarDao.updateUsedCarByUser(usedCarGeneralDto);
            if (result > 0) {
                return R.ok();
            } else {
                return R.fail("修改失败");
            }
        } else {
            return R.fail(checked);
        }
    }

    @Override
    public R getAllUsedCar() {
        List<UsedCarGeneral> list = usedCarDao.getAllUsedCar();
        if (list.size() > 0) {
            return R.ok(list);
        } else {
            return R.fail("无内容！");
        }
    }

    @Override
    public R updateUsedCarFlag(Integer cid, Integer uid, Integer uniqueId) {
        String checked = CheckUtil.paramChecking(cid, uid, uniqueId);
        if (!checked.equals("ok")) {
            return R.fail(checked);
        } else {
            int result = usedCarDao.updateUsedCarFlag(cid, uid, uniqueId);
            if (result > 0) {
                return R.ok();
            } else {
                return R.fail("修改失败！");
            }
        }

    }

    @Override
    public R getUserUsedCar(Integer uid, Integer cid, Integer uniqueId) {
        if (cid != null && cid <= 0) {
            return R.fail("汽车信息输入错误！");
        } else if (uniqueId != null && uniqueId <= 0) {
            return R.fail("uniqueId参数错误！");
        } else if (uid == null || uid <= 0) {
            return R.fail("用户信息输入错误！");
        } else {
            if (cid == null) {
                cid = -1;
            }
            if (uniqueId == null) {
                uniqueId = -1;
            }
            List<UsedCarGeneral> list = usedCarDao.getAllUserUsedCar(uid, cid, uniqueId);
            return R.ok(list);
        }
    }



}

package com.autohome.server.service.impl;

import com.autohome.common.jsonpojo.*;
import com.autohome.common.vo.R;
import com.autohome.entity.UsedCarConfig;
import com.autohome.server.dao.UsedCarConfigDao;
import com.autohome.common.dto.LicencePlateDto;
import com.autohome.server.service.UsedCarConfigService;
import com.autohome.server.util.GsonUtil;
import com.autohome.server.util.UsedCarConfigUtil;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-08 14:48
 **/
@Service
public class UsedCarConfigServiceImpl implements UsedCarConfigService {

    @Autowired
    private UsedCarConfigDao usedCarConfigDao;


    @Override
    public R insertUsedCarConfig(Integer cid, Integer uid, LicencePlate licence) {
        if (cid == null || cid <= 0) {
            return R.fail("汽车信息输入错误！");
        } else if (uid == null || uid <= 0) {
            return R.fail("用户信息输入错误！");
        } else if (licence == null) {
            return R.fail("汽车牌照信息输入错误！");
        } else {
            UsedCarConfig carConfig = new UsedCarConfig();
            carConfig.setLicence_plate(GsonUtil.setObjectToJsonObject(licence));
            carConfig.setCid(cid);
            carConfig.setUid(uid);

            //-------------------------------------
            //注入测试数据
            UsedCarConfigUtil.setInject(carConfig);
            //-------------------------------------

            int result = usedCarConfigDao.insertUsedCarConfig(carConfig);
            if (result > 0) {
                return R.ok();
            } else {
                return R.fail("添加失败！");
            }
        }
    }

    @Override
    public R deleteUsedCarConfig(Integer cid, Integer uid, Integer uniqueId) {
        if (cid == null || cid <= 0) {
            return R.fail("汽车信息输入错误！");
        } else if (uid == null || uid <= 0) {
            return R.fail("用户信息输入错误！");
        } else if (uniqueId == null || uniqueId <= 0) {
            return R.fail("车辆信息输入错误");
        } else {
            if (usedCarConfigDao.deleteUsedCarConfig(cid, uid, uniqueId) > 0) {
                return R.ok();
            } else {
                return R.fail("删除失败！");
            }
        }
    }

    @Transactional
    @Override
    public R updateLicencePlate(LicencePlateDto licencePlateDto) {
        Integer cid = licencePlateDto.getCid();
        Integer uid = licencePlateDto.getUid();
        Integer uniqueId = licencePlateDto.getUniqueId();
        LicencePlate newLicencePlate = licencePlateDto.getLicence_plate();
        if (licencePlateDto == null) {
            return R.fail("未提交需要修改的数据！");
        } else if (cid == null || cid <= 0) {
            return R.fail("汽车信息输入错误！");
        } else if (uid == null || uid <=0) {
            return R.fail("用户信息输入错误！");
        } else if (uniqueId == null || uniqueId <= 0) {
            return R.fail("车辆信息输入错误");
        } else if (newLicencePlate == null) {
            return R.fail("未提交需要修改的数据！");
        } else {
            JsonObject oldLicencePlate = usedCarConfigDao.getLicencePlate(cid, uid, uniqueId);
            if (oldLicencePlate == null) {
                return R.fail("没有该车的信息!");
            } else {
                JsonObject json = UsedCarConfigUtil.setInjectLicencePlate(oldLicencePlate, newLicencePlate);
                if (usedCarConfigDao.updateLicencePlate(cid, uid, uniqueId, json) > 0) {
                    return R.ok();
                } else {
                    return R.fail("没有该车的信息，修改失败！");
                }
            }
        }
    }

    @Override
    public R getUsedCarConfig(Integer cid, Integer uid) {
        if (cid != null && cid <= 0) {
            return R.fail("cid参数错误");
        } else if (uid == null || uid <= 0) {
            return R.fail("uid参数错误");
        } else if (cid == null) {
            cid = -1;
        }
        List<UsedCarConfig> list = usedCarConfigDao.getCarUsedConfig(cid, uid);
        List json = new ArrayList();
        Map<String, Object> map = new LinkedHashMap<>();
        if (list.size() > 0) {
            for (UsedCarConfig carConfig : list) {
                map.clear();
                map.put("base_config", carConfig);
                map.put("safety_equipment_config", GsonUtil.gson.fromJson(carConfig.getSafety_equipment(), SafetyEquipment.class));
                map.put("auxiliary_control_config", GsonUtil.gson.fromJson(carConfig.getAuxiliary_control(), AuxiliaryControl.class));
                map.put("interior_collocation_config", GsonUtil.gson.fromJson(carConfig.getInterior_collocation(), InteriorCollocation.class));
                map.put("media_collocation_config", GsonUtil.gson.fromJson(carConfig.getMedia_collocation(), MediaCollocation.class));
                map.put("licence_plate_config", GsonUtil.gson.fromJson(carConfig.getLicence_plate(), LicencePlate.class));
                json.add(map);
            }
            return R.ok(json);
        } else {
            return R.fail("没有该车信息！");
        }
    }
}

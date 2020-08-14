package com.autohome.server.dao;

import com.autohome.entity.UsedCarGeneral;
import com.autohome.common.dto.UsedCarGeneralDto;

import java.util.List;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-10 01:24
 **/

public interface UsedCarDao {
    //二手车估价，初步添加
    int insertUsedCar(UsedCarGeneralDto usedCarGeneralDto);

    //二手车出售，添加二手车信息
    int insertUsedCar(UsedCarGeneral usedCarGeneral);

    //系统删除二手车（卖出或其他）,二手车详情也得删除
    int deleteUsedCarBySystem(Integer uniqueId);

    //用户将二手车信息下架，flag变为3
    int deleteUsedCarByUser(Integer uid, Integer cid, Integer uniqueId);

    //修改二手车,二手车详情页得修改(用户)
    int updateUsedCarByUser(UsedCarGeneralDto usedCarGeneralDto);

    //查询全部已发布的二手车信息
    List<UsedCarGeneral> getAllUsedCar();

    //修改二手车发布状态为
    int updateUsedCarFlag(Integer cid, Integer uid, Integer flag);

    //查询用户名下所有车辆/同型号的所有车辆/指定车辆
    List<UsedCarGeneral> getAllUserUsedCar(Integer uid, Integer cid, Integer uniqueId);

}

package com.autohome.api.service;

import com.autohome.common.dto.UsedCarGeneralDto;
import com.autohome.common.vo.R;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-11 20:00
 **/
public interface UsedCarService {

    //系统删除二手车（卖出或其他）,二手车详情也得删除
    R deleteUsedCarBySystem(Integer uniqueId);

    //用户将二手车信息下架，flag变为3
    R deleteUsedCarByUser(Integer uid, Integer cid, Integer uniqueId);

    //修改二手车,二手车详情页得修改(用户)
    R updateUsedCarByUser(UsedCarGeneralDto usedCarGeneralDto);

    //查询全部已发布的二手车信息
    R getAllUsedCar();

    //修改二手车发布状态为
    R updateUsedCarFlag(Integer cid, Integer uid, Integer uniqueId);

    /*
        这个方法在controller里是一个接口，
        但是放消费者里好像只能分开写了
     */
    //查询用户名下所有车辆/同型号的所有车辆/指定车辆
    R getUserUsedCar(Integer uid, Integer cid, Integer uniqueId);
    R getUserUsedCar(Integer uid);
    R getUserUsedCar(Integer uid, Integer cid);
}

package com.autohome.server.service;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-08 21:17
 **/
public interface UsedCarUserService {
    //估价，添加状态为未发布的二手车，根据公里数和买车年限返回估值
    int insertUsedCar(int cid);

    //买车
}

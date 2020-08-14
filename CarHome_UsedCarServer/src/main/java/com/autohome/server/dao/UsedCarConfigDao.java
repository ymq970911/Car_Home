package com.autohome.server.dao;

import com.autohome.entity.UsedCarConfig;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-08 14:49
 **/
public interface UsedCarConfigDao {

    //添加汽车详情
    int insertUsedCarConfig(UsedCarConfig usedCarConfig);

    //删除汽车详情
    int deleteUsedCarConfig(int cid, int uid, int uniqueId);

    /**
     * 修改汽车详情，一般的信息不能进行修改，信息与car_config表中的内容必须一致
     * 仅能修改 牌照信息（实体类中为JsonObject类型）
     */
    int updateLicencePlate(int cid, int uid, int uniqueId, JsonObject licence_plate);

    /**
     * 当 cid = -1 时：查询该用户名下所有二手车汽车详情
     * 当 cid > 0 时：查询该用户名下该型号所有的二手车汽车详情
     * @param cid 汽车型号id (required)
     * @param uid 用户id
     * @return
     */
    List<UsedCarConfig> getCarUsedConfig(int cid, int uid);

    JsonObject getLicencePlate(int cid, int uid, int uniqueId);

}

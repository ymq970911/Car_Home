package com.autohome.api.service;

import com.autohome.common.dto.LicencePlateDto;
import com.autohome.common.jsonpojo.LicencePlate;
import com.autohome.common.vo.R;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-12 15:16
 **/

public interface UsedCarConfigService {
    //添加二手车详情
    R insertUsedCarConfig(Integer cid, Integer uid, LicencePlate licence);
    //删除二手车详情
    R deleteUsedCarConfig(Integer cid, Integer uid, Integer uniqueId);

    //修改二手车详情
    R updateLicencePlate(LicencePlateDto dto);

    /**
     * 查询二手车详情
     * @param cid (可为空)
     * @param uid
     * @return
     */
    R getUsedCarConfig(Integer cid, Integer uid);
    R getUsedCarConfig(Integer uid);
}

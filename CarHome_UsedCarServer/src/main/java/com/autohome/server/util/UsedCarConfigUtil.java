package com.autohome.server.util;

import com.autohome.entity.UsedCarConfig;
import com.autohome.common.jsonpojo.*;
import com.google.gson.JsonObject;

import java.util.Date;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-08 17:47
 **/
public class UsedCarConfigUtil {
    //旧的注入新的
    public static JsonObject setInjectLicencePlate(JsonObject oldLP, LicencePlate newLP) {
        LicencePlate licencePlate = GsonUtil.gson.fromJson(oldLP, LicencePlate.class);
        if (newLP.getCarAuditTime() != null && !newLP.getCarAuditTime().equals("")) {
            licencePlate.setCarAuditTime(newLP.getCarAuditTime());
        }
        if (newLP.getCarTaxTime() != null && !newLP.getCarTaxTime().equals("")) {
            licencePlate.setCarTaxTime(newLP.getCarTaxTime());
        }
        if (newLP.getInsuranceDeadlineTime() != null && !newLP.getInsuranceDeadlineTime().equals("")) {
            licencePlate.setInsuranceDeadlineTime(newLP.getInsuranceDeadlineTime());
        }
        if (newLP.getRmaTime() != null && !newLP.getRmaTime().equals("")) {
            licencePlate.setRmaTime(newLP.getRmaTime());
        }
        return GsonUtil.setObjectToJsonObject(licencePlate);
    }

    // 应该由查car_config表注入，但是这个表现在血崩，所以先随便注入点东西吧
    public static UsedCarConfig setInject(UsedCarConfig usedCarConfig) {
        usedCarConfig.setStyle_description("sytle description");
        usedCarConfig.setGuidance_price(0D);
        usedCarConfig.setModel_level("model level");
        usedCarConfig.setEnergy_type(-1);
        usedCarConfig.setEnvironmental_standard(-1);
        usedCarConfig.setTtm(new Date());
        usedCarConfig.setMaximum_power(-1);
        usedCarConfig.setMaximum_torque(-1);
        usedCarConfig.setEngine_type("engine type");
        usedCarConfig.setGearshift_type(-1);
        usedCarConfig.setDisplacement("displacement");
        usedCarConfig.setCar_volume("car volume");
        usedCarConfig.setBody_structure("body structure");
        usedCarConfig.setMaximum_speed(-1);
        usedCarConfig.setAcceleration_capability(0D);
        usedCarConfig.setFuel_consumption(-1);
        usedCarConfig.setWheel_base(-1);
        usedCarConfig.setFuel_capacity(-1);
        usedCarConfig.setTrunk_capacity(-1);
        usedCarConfig.setSafety_equipment(GsonUtil.setObjectToJsonObject(new SafetyEquipment()));
        usedCarConfig.setAuxiliary_control(GsonUtil.setObjectToJsonObject(new AuxiliaryControl()));
        usedCarConfig.setInterior_collocation(GsonUtil.setObjectToJsonObject(new InteriorCollocation()));
        usedCarConfig.setMedia_collocation(GsonUtil.setObjectToJsonObject(new MediaCollocation()));

        return usedCarConfig;
    }

}

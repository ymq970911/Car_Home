package com.autohome.common.jsonpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * @program: car_home
 * @description: used_car_config表中的licence_plate字段  牌照信息
 * @author: ztk
 * @create: 2020-08-08 18:55
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LicencePlate {
    // 车辆年审时间（年.月）  --  String  --  {"carAuditTime":"2020.1"}
    private String carAuditTime;
    // 交强险截止日期（年.月）  --  String  --  {"insuranceDeadlineTime":"2020.1"}
    private String insuranceDeadlineTime;
    // 车使用税有效日期（年.月）  --  String  --  {"carTaxTime":"2020.1"}
    private String carTaxTime;
    // 原厂保质（年.月）  --  String  --  {"rmaTime":"2020.1"}
    private String rmaTime;

    {
        Class cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                //如果是String类型，默认值为-
                if (f.getType() == String.class) {
                    f.set(this, "-");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

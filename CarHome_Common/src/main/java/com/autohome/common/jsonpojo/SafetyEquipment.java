package com.autohome.common.jsonpojo;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * @program: car_home
 * @description: carconfig表中的safety_equipment字段  --  安全设备
 * @author: ztk
 * @create: 2020-08-08 11:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SafetyEquipment {
     // * 主/副驾驶座安全气囊  --  JsonObject  --  {"driverSRS":1,"copilot":1}
     // * 前/后侧排气囊  --  JsonObject  --  {"sideFrontSRS":1,"sideFrontSRS":1}
     // * 前/后排头部气囊  --  JsonObject  --  {"headFrontSRS":1,"headBackSRS":1}
     // * 膝部气囊  --  Integer  --  {”kneeSRS“:1}
     // * 被动行人保护   --  Integer  --  {"passivePedestrianProtection":1}
     // * 胎压监测功能  --  Integer  --  {"tirePressureMonitoring":1}
     // * 缺气保用轮胎  --  Integer  --  {"tiresLackAirProtect":1}
     // * 安全带未系提醒  --  Integer  --  {"seatBeltNotice":1}
     // * ISOFIX儿童座椅接口  --  Integer  --  {"isoFix":1}
     // * ABS防抱死  --  Integer  --  {"abs":1}
     // * 制动力分配  --  Integer  --  {"ebd":1}
     // * 刹车辅助  --  Integer  --  {"eba":1}
     // * 车身稳定控制   --  Integer  --  {"esp":1}
     // * 车道偏离预警系统   --  Integer  --  {"ldw":1}
     // * 夜视系统  --  Integer  --  {"nightVisionSystem":1}
     // * 疲劳驾驶提示  --  Integer  --  {"fatigueDrivingNotice":1}

    private String frontRowSRS;
    private String sidSRS;
    private String headSRS;
    private Integer kneeSRS;
    private Integer passivePedestrianProtection;
    private Integer tirePressureMonitoring;
    private Integer tiresLackAirProtect;
    private Integer seatBeltNotice;
    private Integer iosFix;
    private Integer abs;
    private Integer ebd;
    private Integer eba;
    private Integer esp;
    private Integer ldw;
    private Integer nightVisionSystem;
    private Integer fatigueDrivingNotice;

    {
        Class cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                //如果是Integer类型，默认值为-1
                if(f.getType() == Integer.class){
                    f.set(this, -1);
                }
                //如果是JsonObject类型，默认值为{}
                if (f.getType() == JsonObject.class) {

                    f.set(this, new JsonObject());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

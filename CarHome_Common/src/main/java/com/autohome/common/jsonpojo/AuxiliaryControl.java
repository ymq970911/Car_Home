package com.autohome.common.jsonpojo;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * @program: car_home
 * @description: carconfig表中的auxiliary_control字段  --  辅助/操控配置
 * @author: ztk
 * @create: 2020-08-08 11:40
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuxiliaryControl {
    //  前后车驻车雷达  --  {"front":1,"rear":1}
    private String parkingRadar;
    //  巡航系统  --  {"cruiseControl":1,"customCruise":1}
    private String cruiseSystem;
    //  悬架  --  {"variableSuspension":1,"airSuspension":1,"electromagneticSuspension":1}
    private String suspension;
    //  驾驶辅助影像  --  {"drivingAssistanceImage":1}
    private Integer drivingAssistanceImage;
    //  倒车车侧预警系统  --  {"reverseSideWarningSystem ":1}
    private Integer reverseSideWarningSystem;
    //  驾驶模式切换   --  {"drivingModeSwitch":1}
    private Integer drivingModeSwitch;
    //  自动泊车入位  --  {"autoParkAssist":1}
    private Integer autoParkAssist;
    //  发动机启停技术  --  {"gsg":1}
    private Integer gsg;
    //  自动驻车  --  {"autoHold":1}
    private Integer autoHold;
    //  上坡辅助  --  {"hac":1}
    private Integer hac;
    //  陡坡缓降  --  {"hdc":1}
    private Integer hdc;
    //  差速器功能  --  {"differentialFunction":1}
    private Integer differentialFunction;
    // 涉水感应系统   --  {"wadeSensing":1}
    private Integer wadeSensing;

    {
        Class cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                //如果是Integer类型，默认值为-1
                if (f.getType() == Integer.class) {
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

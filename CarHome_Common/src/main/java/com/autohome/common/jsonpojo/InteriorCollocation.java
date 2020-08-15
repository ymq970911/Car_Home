package com.autohome.common.jsonpojo;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * @program: car_home
 * @description: carconfig表 中的interior_collocation字段  --  内部配置
 * @author: ztk
 * @create: 2020-08-08 13:57
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteriorCollocation {
    // 方向盘材质  --  {"leather":1,"artificialLeather":2,"other":2}
    private String steeringWheelMaterial;
    // 方向盘位置调节  --  {"elevationAdjustment":1,"depthAdjustment":1}
    private String steeringWheelAdjustment;
    // 多功能方向盘  --  {"mfl":1}
    private Integer mfl;
    // 方向盘换挡  --  {"steeringWheelShift":1}
    private Integer steeringWheelShift;
    // 方向盘记忆  --  {"steeringWheelMemory ":1}
    private Integer steeringWheelMemory;
    // 行车电脑显示屏幕   --  {"drivingScreen":1}
    private Integer drivingScreen;
    // 全液晶仪表盘  --  {"fullPanel":1}
    private Integer fullPanel;
    // 内置行车记录仪  --  {"autoDataRecorder":1}
    private Integer autoDataRecorder;
    // 主动降噪  --  {"activeNoiseReduction":1}
    private Integer activeNoiseReduction;
    // 手机无线充电功能  --  {"wirelessCharging":1}
    private Integer wirelessCharging;
    // 电动可调踏板  --  {"electricPedal":1}
    private Integer electricPedal;

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

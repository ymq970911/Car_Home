package com.autohome.common.jsonpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * @program: car_home
 * @description: carconfig表中的media_collocation字段  --  多媒体配置
 * @author: ztk
 * @create: 2020-08-08 14:10
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaCollocation {
    // 中控屏幕  --  {"controlScreen":1}
    private Integer controlScreen;
    // GPS导航系统  --  {"gps":1}
    private Integer gps;
    // 蓝牙/车载电话  --  {"bluetooth":1}
    private Integer bluetooth;
    // 语音识别控制系统  --  {"speechRecognitionSystem":1}
    private Integer speechRecognitionSystem;
    // 手势控制  --  {"gestureControl ":1}
    private Integer gestureControl;
    // 面部识别   --  {"facialRecognition":1}
    private Integer facialRecognition;
    // 指纹识别  --  {"fingerprintRecognition":1}
    private Integer fingerprintRecognition;
    // 车载电视  --  {"carTV":1}
    private Integer carTV;
    // 扬声器数量  --  {"audioNum":12}
    private Integer audioNum;
    // 扬声器品牌  --  String  --  {"audioBrand":"Bose"}
    private String audioBrand;

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
                //如果是Integer类型，默认值为-1
                if (f.getType() == Integer.class) {
                    f.set(this, -1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

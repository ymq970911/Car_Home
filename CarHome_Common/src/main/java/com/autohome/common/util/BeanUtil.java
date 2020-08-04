package com.autohome.common.util;

import com.autohome.common.anno.BeanCopyField;

import java.lang.reflect.Field;

/**
 * @Class: BeanUtil
 * @Description: 基于反射 实现对象的复制  dto -- pojo  复制
 * @Author: Jerry(姜源)
 * @Create: 2018-07-16 11:51
 */
public class BeanUtil {

    /**
     * 类的属性复制：反射实现 dto 复制 pojo
     *
     * @param clz pojo类的 Class 对象
     * @param dto dto类的实例对象
     * @param <T>
     * @return
     */
    public static <T> T copyDto(Class<T> clz, Object dto) {
        try {
            //1.反射创建 pojo 类的实例 - JDK9
            T obj = clz.getDeclaredConstructor().newInstance();
            //2.遍历dto的所有字段
            Field[] fs = dto.getClass().getDeclaredFields();
            for (Field f : fs) {
                String fn;
                //获取注解
                BeanCopyField bcf = f.getAnnotation(BeanCopyField.class);
                if (bcf != null) {
                    fn = bcf.value();
                } else {
                    fn = f.getName();
                }
                //3.获取 pojo 是否存在对应的属性
                Field fd = clz.getDeclaredField(fn);
                //4.设置 pojo+dto 不进行访问校验
                fd.setAccessible(true);
                f.setAccessible(true);
                //5. 设置dto 字段的值到pojo
                fd.set(obj, f.get(dto));
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

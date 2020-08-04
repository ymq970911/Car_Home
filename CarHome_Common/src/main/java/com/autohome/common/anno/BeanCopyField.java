package com.autohome.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: OpenMain
 * @description: 自定义注解 标记dto属性 对应的pojo
 * @author: Jerry(姜源)
 * @create: 2020-07-16 12:06
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BeanCopyField {
    String value() ;
}

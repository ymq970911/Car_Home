package com.autohome.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-28 16:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static R ok() {
        return new R(200, "OK", null);
    }

    public static<E> R ok (E msg) {
        return new R(200, "OK", msg);
    }

    public static R fail(String msg) {
        return new R(400, msg, null);
    }
}
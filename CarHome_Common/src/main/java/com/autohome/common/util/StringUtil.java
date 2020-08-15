package com.autohome.common.util;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-28 20:09
 */
public class StringUtil {
    /**
     * 校验字符串
     *
     * @param strs 待校验的内容
     * @return 非空：true 有空：false
     */
    public static boolean isnoEmpty(String... strs) {
        boolean r = true;
        for (String s : strs) {
            if (s == null || s.length() == 0) {
                r = false;
                break;
            }
        }
        return r;
    }
}

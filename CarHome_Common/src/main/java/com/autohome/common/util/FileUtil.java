package com.autohome.common.util;

import java.util.Random;

/**
 * @program: voter
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-17 12:14
 */
public class FileUtil {
    /**
     * 根据传入的文件名进行 低碰撞的重命名 + 文件名长度限制
     *
     * @param fn
     * @return
     */
    public static String rename(String fn) {
        if (null != fn && 0 != fn.length()) {
            if (fn.length() > 30) {
                fn = fn.substring(fn.length() - 30);
            }
            fn=System.currentTimeMillis()+"_"+new Random().nextInt(1000)+"_"+fn;
            return fn;
        }else {
            return null;
        }
    }
}

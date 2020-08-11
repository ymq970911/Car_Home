package com.autohome.server.util;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-10 11:35
 **/
public class CheckUtil {

    public static String paramChecking(Integer cid, Integer uid, Integer uniqueId) {
        StringBuilder result = new StringBuilder();
        if (cid != null || cid <= 0) {
            result.append("汽车信息输入错误！");
        }
        if (uniqueId != null || uniqueId <= 0) {
            result.append("uniqueId错误！");
        }
        if (uid == null || uid <= 0) {
            result.append("用户信息输入错误！");
            return result.toString();
        }
        return "ok";
    }

    public static String uniqueIdChecking(Integer uniqueId) {
        if (uniqueId != null || uniqueId <= 0) {
            return "uniqueId错误！";
        }
        return "ok";
    }

    public static String cidChecking(Integer cid) {
        if (cid != null || cid <= 0) {
            return "汽车信息输入错误！";
        }
        return "ok";
    }

    public static String uidChecking(Integer uid) {
        if (uid == null || uid <= 0) {
            return "用户信息输入错误！";
        }
        return "ok";
    }

    public static String uidAndCidChecking(Integer cid, Integer uid) {
        StringBuilder result = new StringBuilder();
        if (cid != null || cid <= 0) {
            result.append("汽车信息输入错误！");
        }
        if (uid == null || uid <= 0) {
            result.append("用户信息输入错误！");
            return result.toString();
        }
        return "ok";
    }
}

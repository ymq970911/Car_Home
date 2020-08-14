package com.autohome.cache.service;

import com.autohome.cache.exception.CacheException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: FmOpen
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-08-06 10:34
 */
public interface CacheService {
    //存储数据-5大常用类型
    //存储  字符串
    boolean saveStr2Redis(String key, long expireTimeSeconds, String value) throws CacheException;

    boolean saveList2Redis(String key, long expireTimeSeconds, String... values) throws CacheException;

    boolean saveSet2Redis(String key, long expireTimeSeconds, String... values) throws CacheException;

    boolean saveScoreSet2Redis(String key, long expireTimeSeconds, double score, String value) throws CacheException;

    boolean saveHash2Redis(String key, long expireTimeSeconds, String field, String value) throws CacheException;

    //存储 序列化单个对象
    boolean saveList2Redis(String key, long expireTimeSeconds, Object o) throws CacheException;

    boolean saveSet2Redis(String key, long expireTimeSeconds, Object o) throws CacheException;

    boolean saveScoreSet2Redis(String key, long expireTimeSeconds, double score, Object o) throws CacheException;

    boolean saveHash2Redis(String key, long expireTimeSeconds, String field, Object o) throws CacheException;

    //存储 序列化
    boolean saveStr2Redis(String key, long expireTimeSeconds, Object o) throws CacheException;

    boolean saveList2Redis(String key, long expireTimeSeconds, List<Object> list) throws CacheException;

    boolean saveSet2Redis(String key, long expireTimeSeconds, Set<Object> set) throws CacheException;

    boolean saveScoreSet2Redis(String key, long expireTimeSeconds, Map<Object, Double> map) throws CacheException;

    boolean saveHash2Redis(String key, long expireTimeSeconds, Map<String, Object> map) throws CacheException;

    //查询
    String getStrFromRedis(String key);

    long getListSize(String key);

    List<Object> getListFromRedis(String key);

    boolean checkSet(String key, String val);

    boolean checkSet(String key, Object val);

    Set<Object> getSetFromRedis(String key);

    Map<String, Double> getScoreSetFromRedis(String key, int flag);

    String getHashFromRedis(String key, String field);

    boolean checkHash(String key, String field);

    Map<String, Object> gethashFromRedis(String key);

    Map<String, String> gethashStrFromRedis(String key);

    //校验
    boolean checkKey(String key);

    List<String> keys(String prefile);

    boolean expire(String key, long time, TimeUnit timeUnit);

    boolean delKey(String... keys);

    boolean lock(String key);

    boolean lock(String key, long timeseconds);

    boolean unlock(String key);

    Set<Object> getReverseRangeFromRedis(String key, long start, long end);
}
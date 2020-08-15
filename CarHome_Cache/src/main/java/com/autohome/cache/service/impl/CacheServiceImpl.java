package com.autohome.cache.service.impl;

import com.autohome.cache.exception.CacheException;
import com.autohome.cache.service.CacheService;
import com.autohome.cache.util.RedissonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: FmOpen
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-08-06 10:52
 */
@Slf4j
@Service
@RefreshScope //实时获取统一配置中心的 配置内容
public class CacheServiceImpl implements CacheService {
    @Autowired
    private RedisTemplate<String, Object> template;

    @Value("${spring.redis.host}") //IOC 的属性注入是发送对象实例之后
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String pass;

    private RedissonUtil redissonUtil;

    @PostConstruct()
    public void init() {
        redissonUtil = RedissonUtil.getInstance(host, port, pass);
    }
    // @PreDestroy -- destoryMethod

    /**
     * @param key
     * @param expireTimeSeconds -1 永久有效；-2 Key不存在；其他值 Key有效时间
     * @param value
     * @return 新增是否成功
     */
    @Override
    public boolean saveStr2Redis(String key, long expireTimeSeconds, String value) throws CacheException {
        template.opsForValue().set(key, value, expireTimeSeconds, TimeUnit.SECONDS);
        return true;
    }

    @Override
    public boolean saveList2Redis(String key, long expireTimeSeconds, String... values) throws CacheException {
        for (String v : values) {
            saveStr2Redis(key, expireTimeSeconds, v);
        }
        return true;
    }

    @Override
    public boolean saveSet2Redis(String key, long expireTimeSeconds, String... values) throws CacheException {
        try {
            if (expireTimeSeconds <= 0) {
                expireTimeSeconds = -1;
            }
            log.info(key+values.toString());
            template.opsForSet().add(key, values);
            template.opsForSet().getOperations().expire(key, expireTimeSeconds, TimeUnit.SECONDS);
            log.info("true");
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveScoreSet2Redis(String key, long expireTimeSeconds, double score, String value) throws CacheException {
        try {
            // 放进有序集合里
            template.opsForZSet().add(key, value, score);
            if (expireTimeSeconds > 0) {
                //设置过期时间
                template.opsForSet().getOperations().expire(key, expireTimeSeconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveHash2Redis(String key, long expireTimeSeconds, String field, String value) throws CacheException {
        try {
            template.opsForHash().put(key, field, value);
            if (expireTimeSeconds > 0) {
                template.expire(key, expireTimeSeconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveList2Redis(String key, long expireTimeSeconds, Object o) throws CacheException {
        try {
            if (expireTimeSeconds <= 0) {
                expireTimeSeconds = -1;
            }
            template.opsForList().set(key, expireTimeSeconds, o);
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveSet2Redis(String key, long expireTimeSeconds, Object o) throws CacheException {
        try {
            if (expireTimeSeconds <= 0) {
                expireTimeSeconds = -1;
            }
            template.opsForSet().add(key, o);
            template.opsForSet().getOperations().expire(key, expireTimeSeconds, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveScoreSet2Redis(String key, long expireTimeSeconds, double score, Object o) throws CacheException {
        try {
            template.opsForZSet().add(key, o, score);
            if (expireTimeSeconds <= 0) {
                expireTimeSeconds = -1;
            }
            template.opsForSet().getOperations().expire(key, expireTimeSeconds, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveHash2Redis(String key, long expireTimeSeconds, String field, Object o) throws CacheException {
        try {
            template.opsForHash().put(key, field, o);
            if (expireTimeSeconds > 0) {
                template.expire(key, expireTimeSeconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveStr2Redis(String key, long expireTimeSeconds, Object o) throws CacheException {
        try {
            if (expireTimeSeconds < -1) {
                expireTimeSeconds = -1;
            }
            template.opsForValue().set(key, o, expireTimeSeconds, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("存储异常");
            throw new CacheException("存储异常" + e.getMessage());
        }
    }

    @Override
    public boolean saveList2Redis(String key, long expireTimeSeconds, List<Object> list) throws CacheException {
        for (Object o : list) {
            saveList2Redis(key, expireTimeSeconds, o);
        }
        return true;
    }

    @Override
    public boolean saveSet2Redis(String key, long expireTimeSeconds, Set<Object> set) throws CacheException {
        for (Object s : set) {
            saveSet2Redis(key, expireTimeSeconds, s);
        }
        return true;
    }

    @Override
    public boolean saveScoreSet2Redis(String key, long expireTimeSeconds, Map<Object, Double> map) throws CacheException {
        for (Map.Entry<Object, Double> m : map.entrySet()) {
            saveScoreSet2Redis(key, expireTimeSeconds, m.getValue(), m.getKey());
        }
        return true;
    }

    @Override
    public boolean saveHash2Redis(String key, long expireTimeSeconds, Map<String, Object> map) throws CacheException {
        for (Map.Entry<String, Object> m : map.entrySet()) {
            saveHash2Redis(key, expireTimeSeconds, m.getKey(), m.getValue());
        }
        return true;
    }

    @Override
    public String getStrFromRedis(String key) {
        return template.opsForValue().get(key, 0, -1);
    }

    @Override
    public long getListSize(String key) {
        return template.opsForList().size(key);
    }

    @Override
    public List<Object> getListFromRedis(String key) {
        return template.opsForList().range(key, 0, -1);
    }

    @Override
    public boolean checkSet(String key, String val) {
        return template.opsForSet().isMember(key, val);
    }

    @Override
    public boolean checkSet(String key, Object val) {
        return template.opsForSet().isMember(key, val);
    }

    @Override
    public Set<Object> getSetFromRedis(String key) {
        return template.opsForSet().members(key);
    }

    /**
     * @param key
     * @param flag 0 升序，非0 降序
     * @return
     */
    @Override
    public Map<String, Double> getScoreSetFromRedis(String key, int flag) {
        Map<String, Double> map = new TreeMap<>();
        Set<Object> objects = null;
        if (flag != 0) {
            // 降序
            objects = template.opsForZSet().reverseRange(key, 0, -1);
        } else {
            // 升序
            objects = template.opsForZSet().range(key, 0, -1);
        }

        if (objects != null) {
            for (Object o : objects) {
                map.put((String) o, template.opsForZSet().score(key, o));
            }
        }
        System.out.println(map+"--------------");
        return map;
    }

    @Override
    public String getHashFromRedis(String key, String field) {
        return (String) template.opsForHash().entries(key).get(field);
    }

    @Override
    public boolean checkHash(String key, String field) {
        return template.opsForHash().hasKey(key, field);
    }

    @Override
    public Map<String, Object> gethashFromRedis(String key) {
        Map<String, Object> map = new HashMap<>();
        template.opsForHash().entries(key).forEach((k, v) -> {
            if (k instanceof String) {
                map.put((String) k, v);
            }
        });
        return map;
    }

    @Override
    public Map<String, String> gethashStrFromRedis(String key) {
        Map<String, String> map = new HashMap<>();
        template.opsForHash().entries(key).forEach((k, v) -> {
            if (k instanceof String && v instanceof String) {
                map.put((String) k, (String) v);
            }
        });
        return map;
    }

    @Override
    public boolean checkKey(String key) {
        return template.hasKey(key);
    }

    @Override
    public List<String> keys(String prefile) {
        Set<String> keys = template.keys(prefile + "*");
        List<String> list = null;
        if (keys != null) {
            list = new ArrayList<>(keys);
        }
        return list;
    }

    @Override
    public boolean expire(String key, long time, TimeUnit timeUnit) {
        return template.expire(key, time, timeUnit);
    }

    @Override
    public boolean delKey(String... keys) {
        return template.delete(Arrays.asList(keys)) == keys.length;
    }

    @Override
    public boolean lock(String key) {
        redissonUtil.lock(key);
        return true;
    }

    @Override
    public boolean lock(String key, long timeseconds) {
        redissonUtil.lock(key, timeseconds);
        return true;
    }

    @Override
    public boolean unlock(String key) {
        redissonUtil.unlock(key);
        return true;
    }

    @Override
    public Set<Object> getReverseRangeFromRedis(String key, long start, long end) {
        return  template.opsForZSet().reverseRange(key, start, end);
    }
}

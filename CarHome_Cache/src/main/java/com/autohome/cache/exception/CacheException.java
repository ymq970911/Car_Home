package com.autohome.cache.exception;

/**
 * @program: FmOpen
 * @description: 自定义异常
 * @author: Feri(邢朋辉)
 * @create: 2020-08-06 10:59
 */
public class CacheException extends Exception {
    public CacheException() {
    }

    public CacheException(String msg) {
        super(msg);
    }

    public CacheException(String msg, CacheException exception) {
        super(msg, exception);
    }

}

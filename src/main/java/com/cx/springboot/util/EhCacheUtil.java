package com.cx.springboot.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.text.ParseException;
import java.util.Date;


public class EhCacheUtil {

    /**
     * 设置缓存对象
     *
     * @param key
     * @param value
     */
    public static void setCache(String key, Object value) {
        CacheManager cacheManager = new CacheManager();
        Cache cache = cacheManager.getCache("demo");
        Element element = new Element(key, value);
        cache.put(element);
    }

    /**
     * 从缓存中取出对象
     *
     * @param key
     * @return
     */
    public static Object getCache(String key) {
        Object object = null;
        CacheManager cacheManager = new CacheManager();
        Cache cache = cacheManager.getCache("demo");
        if (cache.get(key) != null && !cache.get(key).equals("")) {
            object = cache.get(key).getObjectValue();
        }
        return object;
    }




}

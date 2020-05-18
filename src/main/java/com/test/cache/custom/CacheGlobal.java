package com.test.cache.custom;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Description Cache全局类
 * @author playboy
 * @date 2020-05-18 10:22
 * version 1.0
 */
public class CacheGlobal {
//	全局缓存对象
	public static ConcurrentHashMap<String,CacheValue> concurrentHashMap = new ConcurrentHashMap<>();
}

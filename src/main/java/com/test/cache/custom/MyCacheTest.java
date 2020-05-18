package com.test.cache.custom;


import lombok.extern.slf4j.Slf4j;

/**
 * Description 自定义缓存测试
 * @author playboy
 * @date 2020-05-18 11:16
 * version 1.0
 */
@Slf4j
public class MyCacheTest {
	public static void main(String[] args) {
		CacheUtils cacheUtils = new CacheUtils();
		cacheUtils.put("key", "lmm", 10000L);
		String val = (String) cacheUtils.get("key");
		log.error(val);
		String noVal = (String) cacheUtils.get("key2");
		log.error(noVal);
	}

}

package com.test.cache.ehCache;


import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * Description ehcache的使用
 * @author playboy
 * @date 2020-05-18 10:04
 * version 1.0
 */
@Slf4j
public class EhCacheExample {
	public static void main(String[] args) {
		//穿建缓存管理器
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
		//初始化 Ehcache
		cacheManager.init();
		//创建缓存（存储器）
		Cache<String,String> cache = cacheManager.createCache("MYCACHE",
				CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,String.class,
						//设置缓存最大容量为10
						ResourcePoolsBuilder.heap(10)));
		//设置缓存
		cache.put("key","hello world");
		//读取缓存
		String value = cache.get("key");
		log.info("value:{}",value);
		//关闭缓存
		cacheManager.close();
	}
}

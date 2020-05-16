package com.test.cache;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Description 通过Guava创建本地缓存
 * @author playboy
 * @date 2020-05-15 09:49
 * version 1.0
 */
public class GuavaExample {
	public static void main(String[] args) throws ExecutionException {
		//	创建方式一：LoadingCache
		LoadingCache<String, String> loadCache = CacheBuilder.newBuilder()
				//并发几倍设置为5，可以同时写缓存的线程数
				.concurrencyLevel(5)
				//设置8秒过期
				.expireAfterWrite(8, TimeUnit.SECONDS)
				//设置缓存容器的初始容量为10
				.initialCapacity(10)
				//设置缓存最大容量为100，超过之后就会按照 LRU 算法移除缓存项
				.maximumSize(100)
				//设置要统计缓存的命中率
				.recordStats()
				//设置缓存的移除通知
				.removalListener(new RemovalListener<Object, Object>() {
					@Override
					public void onRemoval(RemovalNotification<Object, Object> notification) {
						System.out.println(notification.getKey() + "was removed ,cause is " + notification.getCause());
					}
				})
				//指定 CacheLoader，缓存不存在时，可自动加载缓存
				.build(
						new CacheLoader<String, String>() {
							@Override
							public String load(String key) throws Exception {
								return "cache-value: " + key;
							}
						}
				);
		loadCache.put("cl", "hello,cl.");
		String val = loadCache.get("cl");
		System.out.println(val);
		String noVal = loadCache.get("cc");
		System.out.println(noVal);

		//	创建方式二：Callable
		Cache<String, String> cache = CacheBuilder.newBuilder()
				//设置缓存最大长度
				.maximumSize(2)
				.build();
		cache.put("k1", "hello, k1");
		//查询缓存
		String value = cache.get("k1", new Callable<String>() {
			@Override
			public String call() throws Exception {
				//缓存不存在时执行
				return "no this key";
			}
		});

		System.out.println(value);

		String cahceVar = cache.get("k2", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "no this key";
			}
		});
		System.out.println(cahceVar);
	}

}

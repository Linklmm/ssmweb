package com.test.cache.custom;


import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Description 缓存工具类
 * @author playboy
 * @date 2020-05-18 10:33
 * version 1.0
 */
@Slf4j
public class CacheUtils {
	/**
	 * 添加缓存
	 * @param key    key值
	 * @param value  value值
	 * @param expire 过期时间
	 */
	public void put(String key, Object value, Long expire) {
		if (StringUtils.isBlank(key)) {
			log.error("key值不能为空！");
			return;
		}
		//当缓存存在时，更新缓存
		if (CacheGlobal.concurrentHashMap.containsKey(key)) {
			CacheValue cacheValue = CacheGlobal.concurrentHashMap.get(key);
			cacheValue.setHitCount(cacheValue.getHitCount() + 1);
			cacheValue.setCreateTime(System.currentTimeMillis());
			cacheValue.setExpireTime(expire == null ? 0L : expire);
			cacheValue.setLastTime(System.currentTimeMillis());
			cacheValue.setValue(value);
			return;
		}
		//创建缓存
		CacheValue cache = new CacheValue(key, value, expire, System.currentTimeMillis(),
				System.currentTimeMillis(), 1);
		CacheGlobal.concurrentHashMap.put(key, cache);
	}

	/**
	 * 获取缓存
	 * @param key key值
	 * @return
	 */
	public Object get(String key) {
		if (StringUtils.isBlank(key)) {
			log.error("key值不能为空！");
			return null;
		}
		if (CacheGlobal.concurrentHashMap.isEmpty()) {
			log.error("缓存字典为空！");
			return null;
		}
		if (!CacheGlobal.concurrentHashMap.containsKey(key)) {
			log.error("key值不存在！");
			return null;
		}
		CacheValue cacheValue = CacheGlobal.concurrentHashMap.get(key);
		if (cacheValue == null) {
			return null;
		}
		long timeoutTime = TimeUnit.NANOSECONDS.toSeconds(System.currentTimeMillis() - cacheValue.getCreateTime());
		if (cacheValue.getExpireTime() <= timeoutTime) {
			log.error("缓存过期");
			//清除过期缓存
			CacheGlobal.concurrentHashMap.remove(key);
			return null;
		}
		cacheValue.setHitCount(cacheValue.getHitCount() + 1);
		cacheValue.setLastTime(System.currentTimeMillis());
		return cacheValue.getValue();
	}

}

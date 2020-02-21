package com.test.sourceCode;


import com.alibaba.fastjson.JSON;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * Description 测试LInkedHashMap的LRU策略（最少使用删除）
 * @author playboy
 * @date 2020-02-17 11:26
 * version 1.0
 */
@Slf4j
public class testAccessOrder {

	public static void main(String[] args) {
		// 新建 LinkedHashMap accessOrder开启访问最少删除策略
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(4, 0.75f, true) {
			{
				put(10, 10);
				put(9, 9);
				put(20, 20);
				put(1, 1);
			}

			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > 3;
			}
		};
		log.info("初始化：{}", JSON.toJSONString(map));
		Assert.notNull(map.get(9));
		log.info("map.get(9)：{}", JSON.toJSONString(map));
		Assert.notNull(map.get(20));
		log.info("map.get(20)：{}", JSON.toJSONString(map));
	}

}

package com.test.spring.aop.actualCombat.service;


import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description 计算服务耗时
 * @author playboy
 * @date 2020-03-17 15:03
 * version 1.0
 */
@Service
@Slf4j
public class SomeService {
	private Random random = new Random(System.currentTimeMillis());

	public void someMethod() {
		log.info("---SomeService: someMethod invoked---");
		try {
			// 模拟耗时任务
			Thread.sleep(random.nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

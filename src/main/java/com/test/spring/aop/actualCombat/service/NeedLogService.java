package com.test.spring.aop.actualCombat.service;


import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description 日志服务类
 * @author playboy
 * @date 2020-03-17 11:12
 * version 1.0
 */
@Service
@Slf4j
public class NeedLogService {
	private Random random = new Random(System.currentTimeMillis());

	public int logMethod(String someParam){
		log.info("---NeedLogService: logMethod invoked, param: {}---", someParam);
		return random.nextInt();
	}
	public void exceptionMethod() throws Exception {
		log.info("---NeedLogService: exceptionMethod invoked---");
		throw new Exception("Something bad happened!");
	}
}

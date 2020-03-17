package com.test.spring.aop.actualCombat.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description
 * @author playboy
 * @date 2020-03-17 11:14
 * version 1.0
 */
@Slf4j
@Service
public class NormalService {
	public void someMethod() {
		log.info("---NormalService: someMethod invoked---");
	}
}

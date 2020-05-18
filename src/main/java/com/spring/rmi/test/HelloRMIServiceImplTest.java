package com.spring.rmi.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description
 * @author playboy
 * @date 2020-05-16 20:12
 * version 1.0
 */
public class HelloRMIServiceImplTest {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("/rmi/rmiConfig.xml");
	}
}
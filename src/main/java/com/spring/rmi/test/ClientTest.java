package com.spring.rmi.test;



import com.spring.rmi.service.HelloRMIService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description 客户端测试类
 * @author playboy
 * @date 2020-05-16 20:17
 * version 1.0
 */
public class ClientTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("rmi/clientConfig.xml");
		HelloRMIService hms = context.getBean("myClient",HelloRMIService.class);
		System.out.println(hms.getAdd(1,2));
	}
}

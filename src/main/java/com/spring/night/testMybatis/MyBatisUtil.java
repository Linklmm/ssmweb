package com.spring.night.testMybatis;


import java.io.IOException;
import java.io.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Description 测试myBatis
 * @author playboy
 * @date 2020-05-02 17:04
 * version 1.0
 */
@Slf4j
public class MyBatisUtil {
	private final static SqlSessionFactory SQL_SESSION_FACTORY;

	static {
		String resource = "spring/night/spring-mybatisConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory(){
		return SQL_SESSION_FACTORY;
	}
}

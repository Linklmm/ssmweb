package com.spring.night.testMybatis;


import com.alibaba.fastjson.JSON;
import com.spring.night.dao.UserMapper;
import com.spring.po.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

/**
 * Description 测试mapper
 * @author playboy
 * @date 2020-05-02 23:31
 * version 1.0
 */
@Slf4j
public class TestMapper {
	static SqlSessionFactory sqlSessionFactory = null;

	static {
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}

	@Test
	public void testAdd() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User("tom", new Integer(5),"女");
			userMapper.insertUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void getUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.getUser(8);
			log.info("数据为user:{}", JSON.toJSONString(user));
		} finally {
			sqlSession.close();
		}
	}

}

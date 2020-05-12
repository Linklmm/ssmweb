package com.spring.ten.service.impl;


import com.spring.po.User;
import com.spring.ten.service.UserService;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

/**
 * Description 接口实现类
 * @author playboy
 * @date 2020-05-11 08:57
 * version 1.0
 */
public class UserServiceImpl implements UserService {
	private JdbcTemplate jdbcTemplate;

	/**
	 * set注入
	 * 设置数据源
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(User user) throws Exception {
		jdbcTemplate.update("insert into user (name,age,sex)values (?,?,?)",
				new Object[]{user.getName(),user.getAge(),user.getSex()},new int[]{VARCHAR,INTEGER,VARCHAR});
		throw new RuntimeException("aa");
	}

}

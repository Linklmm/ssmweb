package com.spring.ten.dao;



import com.spring.po.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Description 用户数据dao层
 * @author playboy
 * @date 2020-04-22 14:58
 * version 1.0
 */

public class UserRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet resultSet, int i) throws SQLException {
		User person = new User(resultSet.getInt("id"), resultSet.getString("name"),
				resultSet.getInt("age"), resultSet.getString("sex"));
		return person;
	}

}

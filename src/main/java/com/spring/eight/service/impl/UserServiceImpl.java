package com.spring.eight.service.impl;


import com.spring.eight.dao.UserRowMapper;
import com.spring.eight.pojo.User;
import com.spring.eight.service.UserService;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

/**
 * Description 数据操作接口实现
 *
 * @author playboy
 * @date 2020-04-25 08:10
 * version 1.0
 */
public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user (name,age,sex)values (?,?,?)",
                new Object[]{user.getName(), user.getAge(), user.getSex()}, new int[]{VARCHAR, INTEGER, VARCHAR});
    }

    @Override
    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }

}

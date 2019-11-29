package com.test.spring.ch04;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-11 17:40
 * @Version 1.0
 * @Description
 */
public class SimplePostProcessor {
    private String connectionString;
    private String password;
    private String username;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "connectionString:" + this.connectionString + "username:" +
                this.username + "password:" + this.password;
    }
}

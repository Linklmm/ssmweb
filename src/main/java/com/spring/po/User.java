package com.spring.po;


import lombok.Data;

/**
 * Description 用户表
 *
 * @author playboy
 * @date 2020-04-22 14:55
 * version 1.0
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String sex;

    public User(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}

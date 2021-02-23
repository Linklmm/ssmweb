package com.pojo;


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
}

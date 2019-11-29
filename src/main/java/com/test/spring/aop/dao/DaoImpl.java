package com.test.spring.aop.dao;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author myFlowerYourGrass
 * @Date 2019-10-25 09:48
 * @Version 1.0
 * @Description
 */
public class DaoImpl implements Dao {
    @Override
    public void select() {
        System.out.println("Enter DaoImpl.select()");
    }

    @Override
    public void insert() {
        System.out.println("Enter DaoImpl.insert()");
    }
}

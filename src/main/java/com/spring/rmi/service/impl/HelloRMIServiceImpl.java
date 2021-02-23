package com.spring.rmi.service.impl;


import com.spring.rmi.service.HelloRMIService;

/**
 * Description rmi接口实现类
 *
 * @author playboy
 * @date 2020-05-16 20:05
 * version 1.0
 */
public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int a, int b) {
        return a + b;
    }

}

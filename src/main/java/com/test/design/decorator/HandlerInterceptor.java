package com.test.design.decorator;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-21 21:19
 * @description: 模拟spring的HandlerInterceptor------装饰器模式
 **/
public interface HandlerInterceptor {

  boolean preHandle(String request, String response, Object handler);

}

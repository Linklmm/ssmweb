package com.test.design.decorator.us;

import com.test.design.decorator.HandlerInterceptor;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-21 21:21
 * @description: 模拟sso登录功能
 *
 * 需要被装饰的类
 **/
public class SsoInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    //模拟获取cookie
    String ticket = request.substring(1, 8);
    return ticket.equals("success");
  }
}

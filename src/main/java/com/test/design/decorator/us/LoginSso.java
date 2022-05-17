package com.test.design.decorator.us;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-21 21:22
 * @description: 模拟单点登录
 * 通过继承的方式来实现对登录验证的扩展
 *
 * 原先只验证是否成功，不验证用户
 **/
public class LoginSso extends SsoInterceptor {

  private static Map<String, String> authMap = new ConcurrentHashMap<>();

  static {
    authMap.put("huahua", "queryUserInfo");
    authMap.put("doudou", "queryUserInfo");
  }

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    //模拟获取cookie
    String ticket = request.substring(1, 8);
    //模拟校验
    boolean success = ticket.equals("success");
    if (!success) {
      return false;
    }

    String userId = request.substring(9);
    String method = authMap.get(userId);
    //模拟方法校验
    return "queryUserInfo".equals(method);
  }
}

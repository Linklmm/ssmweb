package com.test.design.decorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-21 21:44
 * @description: 装饰角色逻辑实现
 * 通过装饰器类实现方法的扩展。
 **/
@Slf4j
public class LoginSsoDecorator extends SsoDecorator{

  private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

  static {
    authMap.put("huahua", "queryUserInfo");
    authMap.put("doudou", "queryUserInfo");
  }
  public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
    super(handlerInterceptor);
  }

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    //获取cookie
    boolean success = super.preHandle(request, response, handler);
    if (!success){
      return false;
    }
    String userId =request.substring(8);
    String method = authMap.get(userId);
    return "queryUserInfo".equals(method);
  }
}

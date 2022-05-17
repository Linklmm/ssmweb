package com.test.design.decorator;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-21 21:39
 * @description: 抽象类-》装饰角色
 * 装饰类
 **/
public abstract class SsoDecorator implements HandlerInterceptor{

  /**
   * 需要装饰的角色-》ssoInterceptor
   */
  private HandlerInterceptor handlerInterceptor;
  private SsoDecorator(){}

  public SsoDecorator(HandlerInterceptor handlerInterceptor) {
    this.handlerInterceptor = handlerInterceptor;
  }

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    return handlerInterceptor.preHandle(request,response,handler);
  }
}

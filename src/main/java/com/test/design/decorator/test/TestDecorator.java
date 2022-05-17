package com.test.design.decorator.test;

import com.test.design.decorator.LoginSsoDecorator;
import com.test.design.decorator.us.LoginSso;
import com.test.design.decorator.us.SsoInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-21 21:33
 * @description: 测试类
 *
 * 装饰器主要解决的是直接继承下因功能的不断横向扩展导致子类膨胀的问题，
 * 而是用装饰器模式后就会比直接继承显得更加灵活同时这样也就不再需要考虑子类的维护。
 *
 * 在装饰器模式中有四个比较重要点抽象出来的点；
 *
 * 抽象构件角色(Component) - 定义抽象接口
 * 具体构件角色(ConcreteComponent) - 实现抽象接口，可以是一组
 * 装饰角色(Decorator) - 定义抽象类并继承接口中的方法，保证一致性
 * 具体装饰角色(ConcreteDecorator) - 扩展装饰具体的实现逻辑
 **/
@Slf4j
public class TestDecorator {

  /**
   * 正常的实现方式
   */
  @Test
  public void testLogin() {
    LoginSso ssoDecorator = new LoginSso();
    String request = "1successhuahua";
    boolean success = ssoDecorator.preHandle(request, "jionliuliu", "t");
    log.error("登录校验:{},是否放行：{}", request, success);
  }

  @Test
  public void testDecorator(){
    LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
    String request = "1successhuahua";
    boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
    log.error("登录校验:{},是否放行：{}", request, success);
  }

}

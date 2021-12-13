package com.test.test2;

import com.test.test.pojo.RequestA;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-25 19:54
 * @description:
 **/
public class A extends B{

  @Override
  public RequestA test() {
    return new RequestA();
  }
}

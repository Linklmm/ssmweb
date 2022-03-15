package com.test.proxy.dynamic.asm.impl;

import com.test.proxy.dynamic.asm.IUserApi;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-14 22:44
 * @description: 接口实现
 **/
public class UserApi implements IUserApi {

  @Override
  public String queryUserInfo() {
    return "user is done";
  }
}

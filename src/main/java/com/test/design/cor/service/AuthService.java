package com.test.design.cor.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-23 21:49
 * @description: 模拟审核服务
 **/
public class AuthService {

  private static Map<String, Date> authMap = new ConcurrentHashMap<>();

  /**
   * 查询审核结果
   * @param uId
   * @param orderId
   * @return
   */
  public static Date queryAuthInfo(String uId, String orderId) {
    return authMap.get(uId.concat(orderId));
  }

  /**
   * 处理审核
   * @param uId
   * @param orderId
   */
  public static void auth(String uId, String orderId) {
    authMap.put(uId.concat(orderId), new Date());
  }

}

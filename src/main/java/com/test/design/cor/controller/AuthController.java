package com.test.design.cor.controller;

import com.test.design.cor.service.AuthService;
import com.test.design.cor.pojo.AuthInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-23 21:52
 * @description: 正常代码实现
 **/
public class AuthController {

  private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {
    //三级审批
    Date date = AuthService.queryAuthInfo("1000013", orderId);
    if (Objects.isNull(date)) {
      return new AuthInfo("0001", "单号", orderId, "状态：待三级审核负责人", "王工");
    }

    if (authDate.after(f.parse("2020-06-01 00:00:00")) && authDate
        .before(f.parse("2022-02-25 23:59:59"))) {
      date = AuthService.queryAuthInfo("1000012", orderId);
      if (Objects.isNull(date)) {
        return new AuthInfo("0001", "单号", orderId, "状态：待二级审核负责人", "李工");
      }
    }

    if (authDate.after(f.parse("2020-06-11 00:00:00")) && authDate
        .before(f.parse("2022-02-23 23:59:59"))) {
      date = AuthService.queryAuthInfo("100011", orderId);
      if (Objects.isNull(date)) {
        return new AuthInfo("0001", "单号", orderId, "状态：待一级审核负责人", "段工");
      }
    }

    return new AuthInfo("0001", "单号", orderId, "审批完成");
  }

}

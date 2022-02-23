package com.test.design.cor.design;

import com.test.design.cor.pojo.AuthInfo;
import com.test.design.cor.service.AuthService;
import java.text.ParseException;
import java.util.Date;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-23 22:26
 * @description: 二级审核人
 **/
public class Level2AuthLink extends AuthLink {

  private Date beginDate = f.parse("2020-06-11 00:00:00");
  private Date endDate = f.parse("2022-06-20 23:59:59");

  public Level2AuthLink(String levelUserId, String levelUserName) throws ParseException {
    super(levelUserId, levelUserName);
  }

  @Override
  public AuthInfo doAuth(String uId, String orderId, Date authDate) {
    Date date = AuthService.queryAuthInfo(levelUserId, orderId);
    if (null == date) {
      return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", levelUserName);
    }
    AuthLink next = super.next();
    if (null == next) {
      return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：",
          levelUserName);
    }

    if (authDate.before(beginDate) || authDate.after(endDate)) {
      return next.doAuth(uId, orderId, authDate);
    }

    return next.doAuth(uId, orderId, authDate);
  }
}

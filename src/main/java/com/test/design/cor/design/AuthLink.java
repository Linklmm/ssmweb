package com.test.design.cor.design;

import com.test.design.cor.pojo.AuthInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-23 22:22
 * @description: 责任链-链路抽象类
 **/
@Slf4j
public abstract class AuthLink {

  protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式化
  protected String levelUserId;                           // 级别人员ID
  protected String levelUserName;                         // 级别人员姓名
  private AuthLink next;

  public AuthLink(String levelUserId, String levelUserName) {
    this.levelUserId = levelUserId;
    this.levelUserName = levelUserName;
  }

  /**
   * 获取下一个链路
   *
   * @return
   */
  public AuthLink next() {
    if (Objects.nonNull(next)) {
      log.error("当前类：{},下一个类：{}", this.getClass().getSimpleName(), next.getClass().getSimpleName());
    }else {
      log.error("最后一个类:{}",this.getClass().getSimpleName());
    }
    return next;
  }

  /**
   * 增加链路
   *
   * @param next
   * @return
   */
  public AuthLink appendNext(AuthLink next) {
    this.next = next;
    return this;
  }

  /**
   * 是否审核 查询审核结果
   *
   * @param uId
   * @param orderId
   * @param authDate
   * @return
   */
  public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}

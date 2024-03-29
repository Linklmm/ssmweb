package com.test.design.factory;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-12 22:46
 * @description: 入参
 **/
@Data
public class AwardReq implements Serializable {

  private static final long serialVersionUID = 1346096579218367448L;
  // 用户唯一ID
  private String uId;
  // 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
  private Integer awardType;
  // 奖品编号；sku、couponNumber、cardId
  private String awardNumber;
  // 业务ID，防重复
  private String  bizId;
  // 扩展信息
  private Map<String,String> extMap;
}

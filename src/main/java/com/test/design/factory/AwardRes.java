package com.test.design.factory;

import java.io.Serializable;
import lombok.Data;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-12 22:49
 * @description: 出参
 **/
@Data
public class AwardRes implements Serializable {

  private static final long serialVersionUID = -7799034500145146748L;
  // 编码
  private String code;
  // 描述
  private String info;
}

package com.test.design.cor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-23 21:55
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthInfo {
  private String code;
  private String info = "";

  public AuthInfo(String code, String ...infos) {
    this.code = code;
    for (String str:infos){
      this.info = this.info.concat(str);
    }
  }
}

package com.test.design.combination;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 21:51
 * @description: 组合模式
 **/
@Slf4j
public class EngineController {

  public String process(String userId, String userSex, int userAge) {
    log.info("if else 实现方式判断用户结果，userId:{},userSex:{},userAge:{}", userId, userSex, userAge);
    if ("man".equals(userSex)){
      if (userAge<25){
        return "果实A";
      }else {
        return "果实B";
      }
    }
    if ("woman".equals(userSex)){
      if (userAge<25){
        return "果实C";
      }else {
        return "果实D";
      }
    }
    return null;
  }
}

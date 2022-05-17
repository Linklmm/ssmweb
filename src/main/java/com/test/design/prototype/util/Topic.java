package com.test.design.prototype.util;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-08 21:16
 * @description:
 **/
@Getter
@Setter
public class Topic {
  private Map<String, String> option;  // 选项；A、B、C、D
  private String key;           // 答案；B

  public Topic() {
  }

  public Topic(Map<String, String> option, String key) {
    this.option = option;
    this.key = key;
  }

}

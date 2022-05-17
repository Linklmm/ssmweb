package com.test.design.prototype.pojo;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-08 20:56
 * @description: 选择题-原型设计模式
 **/
@Getter
@Setter
public class ChoiceQuestion {
  private String name;
  private Map<String,String> option;
  private String key;

  public ChoiceQuestion() {
  }

  public ChoiceQuestion(String name, Map<String, String> option, String key) {
    this.name = name;
    this.option = option;
    this.key = key;
  }
}

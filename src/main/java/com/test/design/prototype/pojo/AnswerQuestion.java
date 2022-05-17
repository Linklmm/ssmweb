package com.test.design.prototype.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-08 20:52
 * @description: 简答题-原型设计模式
 **/
@Getter
@Setter
public class AnswerQuestion {

  /**
   * 问题
   */
  private String name;
  /**
   * 答案
   */
  private String key;

  public AnswerQuestion() {
  }

  public AnswerQuestion(String name, String key) {
    this.name = name;
    this.key = key;
  }
}

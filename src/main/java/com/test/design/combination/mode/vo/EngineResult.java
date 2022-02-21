package com.test.design.combination.mode.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 22:29
 * @description: 决策结果
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EngineResult {

  //执行结果
  private boolean isSuccess;
  //用户ID
  private String userId;
  //规则树ID
  private Long treeId;
  //果实节点ID
  private Long nodeId;
  //果实节点值
  private String nodeValue;

  public EngineResult(String userId, Long treeId, Long nodeId, String nodeValue) {
    this.isSuccess = true;
    this.userId = userId;
    this.treeId = treeId;
    this.nodeId = nodeId;
    this.nodeValue = nodeValue;
  }
}

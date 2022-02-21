package com.test.design.combination.mode.vo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 22:25
 * @description: 规则树节点信息
 **/
@Getter
@Setter
public class TreeNode {
  private Long treeId;
  private Long treeNodeId;
  private Integer nodeType;
  private String nodeValue;
  private String ruleKey;
  private String ruleDesc;
  private List<TreeNodeLink> treeNodeLinks;

}

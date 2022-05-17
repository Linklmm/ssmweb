package com.test.design.combination.mode.aggregates;

import com.test.design.combination.mode.vo.TreeNode;
import com.test.design.combination.mode.vo.TreeRoot;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 20:45
 * @description:
 * 规则树聚合
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeRich {
  private TreeRoot treeRoot;                          //树根信息
  private Map<Long, TreeNode> treeNodeMap;        //树节点ID -> 子节点
}

package com.test.design.combination.service.engine.impl;

import com.test.design.combination.mode.aggregates.TreeRich;
import com.test.design.combination.mode.vo.EngineResult;
import com.test.design.combination.mode.vo.TreeNode;
import com.test.design.combination.service.engine.EngineBase;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 21:29
 * @description: 决策引擎的实现
 * 这里对于决策引擎的实现就非常简单了，通过传递进来的必要信息；决策树信息、决策物料值，来做具体的树形结构决策。
 **/
public class TreeEngineHandle extends EngineBase {

  @Override
  public EngineResult process(Long treeId, String userId, TreeRich treeRich,
      Map<String, String> decisionMatter) {
    TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
    return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
  }
}

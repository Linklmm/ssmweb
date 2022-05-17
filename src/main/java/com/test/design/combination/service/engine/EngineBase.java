package com.test.design.combination.service.engine;

import com.test.design.combination.mode.aggregates.TreeRich;
import com.test.design.combination.mode.vo.TreeNode;
import com.test.design.combination.mode.vo.TreeRoot;
import com.test.design.combination.service.logic.LogicFilter;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 21:21
 * @description: 基础决策引擎功能
 * 这里主要提供决策树流程的处理过程，有点像通过链路的关系(性别、年龄)在二叉树中寻找果实节点的过程。
 * 同时提供一个抽象方法，执行决策流程的方法供外部去做具体的实现。
 * #
 **/
@Slf4j
public abstract class EngineBase extends EngineConfig implements IEngine {

  protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId,
      Map<String, String> decisionMatter) {
    TreeRoot treeRoot = treeRich.getTreeRoot();
    Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
    //规则树根ID
    Long rootNodeId = treeRoot.getTreeRootNodeId();
    TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
    //节点类型【NodeType】:1子叶、2果实
    while (treeNodeInfo.getNodeType().equals(1)) {
      String ruleKey = treeNodeInfo.getRuleKey();
      LogicFilter logicFilter = logicFilterMap.get(ruleKey);
      String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
      Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinks());
      treeNodeInfo = treeNodeMap.get(nextNode);
      log.info("决策树引擎=》{},userId:{},treeId:{},treeNode:{},ruleKey:{},matterValue:{}",
          treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey,
          matterValue);
    }
    return treeNodeInfo;
  }
}

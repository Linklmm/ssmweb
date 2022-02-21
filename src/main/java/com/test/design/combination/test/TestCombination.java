package com.test.design.combination.test;

import com.alibaba.fastjson.JSON;
import com.test.design.combination.EngineController;
import com.test.design.combination.mode.aggregates.TreeRich;
import com.test.design.combination.mode.vo.EngineResult;
import com.test.design.combination.mode.vo.TreeNode;
import com.test.design.combination.mode.vo.TreeNodeLink;
import com.test.design.combination.mode.vo.TreeRoot;
import com.test.design.combination.service.engine.IEngine;
import com.test.design.combination.service.engine.impl.TreeEngineHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 21:56
 * @description: 组合模式测试类
 **/
@Slf4j
public class TestCombination {

  @Test
  public void testCommon() {
    EngineController engineController = new EngineController();
    String process = engineController.process("jkjkjj", "man", 29);
    log.info("测试结果:{}", process);
  }

  public static TreeRich init() {
    TreeNode treeNode = new TreeNode();
    treeNode.setTreeId(10001L);
    treeNode.setTreeNodeId(1L);
    treeNode.setNodeType(1);
    treeNode.setNodeValue(null);
    treeNode.setRuleKey("userGender");

    //链接1-》11
    TreeNodeLink treeNodeLink = new TreeNodeLink();
    treeNodeLink.setNodeIdFrom(1L);
    treeNodeLink.setNodeIdTo(11L);
    treeNodeLink.setRuleLimitType(1);
    treeNodeLink.setRuleLimitValue("man");

    TreeNodeLink treeNodeLink2 = new TreeNodeLink();
    treeNodeLink2.setNodeIdFrom(1L);
    treeNodeLink2.setNodeIdTo(12L);
    treeNodeLink2.setRuleLimitType(1);
    treeNodeLink2.setRuleLimitValue("woman");
    List<TreeNodeLink> treeNodeLinkList = new ArrayList<>();
    treeNodeLinkList.add(treeNodeLink);
    treeNodeLinkList.add(treeNodeLink2);
    treeNode.setTreeNodeLinks(treeNodeLinkList);

    // 节点：11
    TreeNode treeNode_11 = new TreeNode();
    treeNode_11.setTreeId(10001L);
    treeNode_11.setTreeNodeId(11L);
    treeNode_11.setNodeType(1);
    treeNode_11.setNodeValue(null);
    treeNode_11.setRuleKey("userAge");
    treeNode_11.setRuleDesc("用户年龄");
    // 链接：11->111
    TreeNodeLink treeNodeLink_111 = new TreeNodeLink();
    treeNodeLink_111.setNodeIdFrom(11L);
    treeNodeLink_111.setNodeIdTo(111L);
    treeNodeLink_111.setRuleLimitType(3);
    treeNodeLink_111.setRuleLimitValue("25");
    // 链接：11->112
    TreeNodeLink treeNodeLink_112 = new TreeNodeLink();
    treeNodeLink_112.setNodeIdFrom(11L);
    treeNodeLink_112.setNodeIdTo(112L);
    treeNodeLink_112.setRuleLimitType(5);
    treeNodeLink_112.setRuleLimitValue("25");
    List<TreeNodeLink> treeNodeLinkList_11 = new ArrayList<>();
    treeNodeLinkList_11.add(treeNodeLink_111);
    treeNodeLinkList_11.add(treeNodeLink_112);
    treeNode_11.setTreeNodeLinks(treeNodeLinkList_11);
    // 节点：12
    TreeNode treeNode_12 = new TreeNode();
    treeNode_12.setTreeId(10001L);
    treeNode_12.setTreeNodeId(12L);
    treeNode_12.setNodeType(1);
    treeNode_12.setNodeValue(null);
    treeNode_12.setRuleKey("userAge");
    treeNode_12.setRuleDesc("用户年龄");
    // 链接：12->121
    TreeNodeLink treeNodeLink_121 = new TreeNodeLink();
    treeNodeLink_121.setNodeIdFrom(12L);
    treeNodeLink_121.setNodeIdTo(121L);
    treeNodeLink_121.setRuleLimitType(3);
    treeNodeLink_121.setRuleLimitValue("25");
    // 链接：12->122
    TreeNodeLink treeNodeLink_122 = new TreeNodeLink();
    treeNodeLink_122.setNodeIdFrom(12L);
    treeNodeLink_122.setNodeIdTo(122L);
    treeNodeLink_122.setRuleLimitType(5);
    treeNodeLink_122.setRuleLimitValue("25");
    List<TreeNodeLink> treeNodeLinkList_12 = new ArrayList<>();
    treeNodeLinkList_12.add(treeNodeLink_121);
    treeNodeLinkList_12.add(treeNodeLink_122);
    treeNode_12.setTreeNodeLinks(treeNodeLinkList_12);
    // 节点：111
    TreeNode treeNode_111 = new TreeNode();
    treeNode_111.setTreeId(10001L);
    treeNode_111.setTreeNodeId(111L);
    treeNode_111.setNodeType(2);
    treeNode_111.setNodeValue("果实A");
    // 节点：112
    TreeNode treeNode_112 = new TreeNode();
    treeNode_112.setTreeId(10001L);
    treeNode_112.setTreeNodeId(112L);
    treeNode_112.setNodeType(2);
    treeNode_112.setNodeValue("果实B");
    // 节点：121
    TreeNode treeNode_121 = new TreeNode();
    treeNode_121.setTreeId(10001L);
    treeNode_121.setTreeNodeId(121L);
    treeNode_121.setNodeType(2);
    treeNode_121.setNodeValue("果实C");
    // 节点：122
    TreeNode treeNode_122 = new TreeNode();
    treeNode_122.setTreeId(10001L);
    treeNode_122.setTreeNodeId(122L);
    treeNode_122.setNodeType(2);
    treeNode_122.setNodeValue("果实D");
    // 树根
    TreeRoot treeRoot = new TreeRoot();
    treeRoot.setTreeId(10001L);
    treeRoot.setTreeRootNodeId(1L);
    treeRoot.setTreeName("规则决策树");
    Map<Long, TreeNode> treeNodeMap = new HashMap<>();
    treeNodeMap.put(1L, treeNode);
    treeNodeMap.put(11L, treeNode_11);
    treeNodeMap.put(12L, treeNode_12);
    treeNodeMap.put(111L, treeNode_111);
    treeNodeMap.put(112L, treeNode_112);
    treeNodeMap.put(121L, treeNode_121);
    treeNodeMap.put(122L, treeNode_122);
    return new TreeRich(treeRoot, treeNodeMap);
  }

  @Test
  public void testTree() {
    TreeRich treeRich = init();
    log.info("决策树组合结构信息：\r\n" + JSON.toJSONString(treeRich));

    IEngine treeEngineHandle = new TreeEngineHandle();
    Map<String, String> decisionMatter = new HashMap<>();
    decisionMatter.put("gender", "man");
    decisionMatter.put("age", "29");

    EngineResult result = treeEngineHandle.process(10001L, "Oli09pLkdjh", treeRich, decisionMatter);

    log.info("测试结果：{}", JSON.toJSONString(result));
  }
}

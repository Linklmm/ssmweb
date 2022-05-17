package com.test.design.combination.service.logic;

import com.test.design.combination.mode.vo.TreeNodeLink;
import java.util.List;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 22:23
 * @description: 树节点逻辑过滤接口
 **/
public interface LogicFilter {

  /**
   * 逻辑决策器
   * @param matterValue
   * @param treeNodeLinkList
   * @return
   */
  Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

  /**
   * 获取决策值
   * @param treeId
   * @param userId
   * @param decisionMatter
   * @return
   */
  String matterValue(Long treeId,String userId, Map<String,String> decisionMatter);
}

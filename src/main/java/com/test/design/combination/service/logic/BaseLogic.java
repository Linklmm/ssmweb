package com.test.design.combination.service.logic;

import com.test.design.combination.mode.vo.TreeNodeLink;
import com.test.design.combination.service.logic.LogicFilter;
import java.util.List;
import java.util.Optional;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 22:32
 * @description: 决策基类提供基础服务
 **/
public abstract class BaseLogic implements LogicFilter {

  @Override
  public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
    Optional<Long> optionalLong = treeNodeLinkList.stream()
        .filter(treeNodeLink -> decisionLogic(matterValue, treeNodeLink))
        .map(TreeNodeLink::getNodeIdTo).findAny();
    return optionalLong.orElse(0L);
  }


  private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
    switch (nodeLink.getRuleLimitType()) {
      case 1:
        return matterValue.equals(nodeLink.getRuleLimitValue());
      case 2:
        return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
      case 3:
        return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
      case 4:
        return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
      case 5:
        return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
      default:
        return false;
    }
  }
}

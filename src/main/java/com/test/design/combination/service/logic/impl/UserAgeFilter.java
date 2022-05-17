package com.test.design.combination.service.logic.impl;

import com.test.design.combination.service.logic.BaseLogic;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 20:36
 * @description: 年龄节点
 **/
public class UserAgeFilter extends BaseLogic {

  @Override
  public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
    return decisionMatter.get("age");
  }
}

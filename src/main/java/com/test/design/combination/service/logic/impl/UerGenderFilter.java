package com.test.design.combination.service.logic.impl;

import com.test.design.combination.service.logic.BaseLogic;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 20:43
 * @description: 性别节点
 **/
public class UerGenderFilter extends BaseLogic {

  @Override
  public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
    return decisionMatter.get("gender");
  }
}

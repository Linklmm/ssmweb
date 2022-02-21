package com.test.design.combination.service.engine;

import com.test.design.combination.mode.aggregates.TreeRich;
import com.test.design.combination.mode.vo.EngineResult;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 20:44
 * @description: 决策引擎接口
 **/
public interface IEngine {

  EngineResult process(final Long treeId, final String userId, TreeRich treeRich,
      Map<String, String> decisionMatter);
}

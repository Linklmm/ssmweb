package com.test.design.combination.service.engine;

import com.test.design.combination.service.logic.LogicFilter;
import com.test.design.combination.service.logic.impl.UserAgeFilter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-20 21:19
 * @description: 决策节点配置
 * 在这里将可提供服务的决策节点配置到map结构中，对于这样的map结构可以抽取到数据库中，那么就可以非常方便的管理。
 * #
 **/
public class EngineConfig {

  @Getter
  @Setter
  static Map<String, LogicFilter> logicFilterMap;

  static {
    logicFilterMap = new ConcurrentHashMap<>();
    logicFilterMap.put("userAge", new UserAgeFilter());
    logicFilterMap.put("userGender", new UserAgeFilter());
  }
}

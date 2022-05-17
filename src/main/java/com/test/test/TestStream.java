package com.test.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.test.test.pojo.Base;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-04-14 20:41
 * @description: 测试Java8 Stream
 **/
@Slf4j
public class TestStream {

  public static List<Base> getBases() {
    Base base1 = new Base(1, 1, Boolean.FALSE);
    Base base2 = new Base(3, 2, Boolean.FALSE);
    Base base3 = new Base(1, 3, Boolean.FALSE);
    Base base4 = new Base(null, 4, Boolean.FALSE);
    Base base5 = new Base(2, 5, Boolean.FALSE);
    Base base6 = new Base(3, 6, Boolean.FALSE);
    return Lists.newArrayList(base1, base2, base3,
        base4, base5, base6);
  }

  @Test
  public void testGroupBy() {
    List<Base> baseList = getBases();
    Map<Integer, List<Base>> listMap = baseList.stream().collect(Collectors.groupingBy(Base::getI));
    log.error(JSON.toJSONString(listMap));
  }

  @Test
  public void testToNullValueMap() {
    List<Base> baseList = getBases();
    Map<Integer, Integer> listMap = baseList.stream()
        .collect(Collectors.toMap(Base::getJ, Base::getI));
  }

  @Test
  public void testGroupBy2() {
    List<Base> baseList = getBases();
    Map<Integer, List<Base>> listMap = baseList.stream()
        .filter(base -> Objects.nonNull(base.getI())).collect(Collectors.groupingBy(Base::getI));
    log.error(JSON.toJSONString(listMap));
    Map<Optional<Integer>, List<Base>> listMap1 = baseList.stream()
        .collect(Collectors.groupingBy(base -> Optional.ofNullable(base.getI())));
    log.error(JSON.toJSONString(listMap1.get(Optional.empty())));
    log.error(JSON.toJSONString(listMap1.get(Optional.of(1))));
    log.error(JSON.toJSONString(listMap1.get(1)));

  }

  @Test
  public void testToNullValueMap2() {
    List<Base> baseList = getBases();
    Map<Integer, Integer> listMap = baseList.stream()
        .collect(HashMap::new, (map, item) -> map.put(item.getJ(), item.getI()), HashMap::putAll);
    log.error(JSON.toJSONString(listMap));
    Map<Integer, Integer> listMap2 = Maps.newHashMap();
    baseList.forEach(base -> listMap2.put(base.getJ(), base.getI()));
    log.error(JSON.toJSONString(listMap2));
    Map<Optional<Integer>, Optional<Integer>> listMap3 = baseList.stream().collect(
        Collectors.toMap(base -> Optional.ofNullable(base.getJ()),
            base -> Optional.ofNullable(base.getI()),
            (a, b) -> b, HashMap::new)
    );
    log.error(JSON.toJSONString(listMap3));
  }
}

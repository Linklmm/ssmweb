package com.test.design.prototype.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-08 21:11
 * @description: 题目选项乱序操作工具包
 **/
public class TopicRandomUtil {

  public static Topic random(Map<String, String> option, String key) {
    Set<String> keySet = option.keySet();
    ArrayList<String> keyList = new ArrayList<String>(keySet);
    Collections.shuffle(keyList);
    HashMap<String, String> optionNew = new HashMap<String, String>();
    int idx = 0;
    String keyNew = "";
    for (String next : keySet) {
      String randomKey = keyList.get(idx++);
      if (key.equals(next)) {
        keyNew = randomKey;
      }
      optionNew.put(randomKey, option.get(next));
    }
    return new Topic(optionNew, keyNew);

  }

}

package com.test.design.adapter.adapter;

import com.alibaba.fastjson.JSON;
import com.test.design.adapter.adapter.pojo.RebateInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:54
 * @description: mq适配------适配器模式
 **/
public class MqAdapter {

  public static RebateInfo filter(String strJson, Map<String, String> link)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    return filter(JSON.parseObject(strJson, Map.class), link);
  }

  public static RebateInfo filter(Map obj, Map<String, String> link)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    RebateInfo rebateInfo = new RebateInfo();
    for (String key : link.keySet()) {
      Object val = obj.get(link.get(key));
      //时间特殊处理
      if ("bizTime".equals(key)) {
        RebateInfo.class
            .getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), Date.class)
            .invoke(rebateInfo, new Date((Long) val));
      } else {
        RebateInfo.class
            .getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class)
            .invoke(rebateInfo, val.toString());
      }
    }
    return rebateInfo;
  }
}

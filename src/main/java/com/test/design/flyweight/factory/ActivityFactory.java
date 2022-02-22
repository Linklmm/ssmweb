package com.test.design.flyweight.factory;

import com.test.design.flyweight.domain.Activity;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-22 20:30
 * @description: 享元工厂
 * 这里提供的是一个享元工厂🏭，通过map结构存放已经从库表或者接口中查询到的数据，存放到内存中，用于下次可以直接获取。
 * 这样的结构一般在我们的编程开发中还是比较常见的，当然也有些时候为了分布式的获取，会把数据存放到redis中，可以按需选择
 *
 *
 *
 * 在一些有大量重复对象可复用的场景下，使用此场景在服务端减少接口的调用，在客户端减少内存的占用。是这个设计模式的主要应用方式。
 **/
public class ActivityFactory {
  //缓存活动信息
  static Map<Long, Activity> activityMap = new HashMap<>();

  public static Activity getActivity(Long id){
    Activity activity = activityMap.get(id);
    if (Objects.isNull(activity)){
      // 模拟从实际业务应用从接口中获取活动信息
      activity = new Activity();
      activity.setId(10001L);
      activity.setName("图书嗨乐");
      activity.setDesc("图书优惠券分享激励分享活动第二期");
      activity.setStartTime(new Date());
      activity.setStopTime(new Date());
      activityMap.put(id, activity);
    }
    return activity;
  }
}

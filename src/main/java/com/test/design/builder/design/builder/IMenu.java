package com.test.design.builder.design.builder;

import com.test.design.builder.Matter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-25 21:03
 * @description: 包装接口
 **/
public interface IMenu {

  IMenu appendCeiling(Matter matter); // 吊顶

  IMenu appendCoat(Matter matter);    // 涂料

  IMenu appendFloor(Matter matter);   // 地板

  IMenu appendTile(Matter matter);    // 地砖

  String getDetail();
}

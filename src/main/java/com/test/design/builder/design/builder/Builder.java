package com.test.design.builder.design.builder;

import com.test.design.builder.ceilling.LevelOneCeiling;
import com.test.design.builder.ceilling.LevelTwoCeiling;
import com.test.design.builder.coat.DuluxCoat;
import com.test.design.builder.coat.LiBangCoat;
import com.test.design.builder.floor.ShengXiangFloor;
import com.test.design.builder.title.DongPengTile;
import com.test.design.builder.title.MarcoPoloTile;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-25 21:00
 * @description: 构造者模式，构造复杂对象 建造者类具体的各种组装由此类实现。
 **/
public class Builder {

  public IMenu levelOne(BigDecimal area) {
    return new PackageMenu(area, "豪华欧式")
        .appendCeiling(new LevelTwoCeiling())
        .appendCeiling(new DuluxCoat())
        .appendFloor(new ShengXiangFloor());
  }

  public IMenu levelTwo(BigDecimal area) {
    return new PackageMenu(area, "轻奢田园")
        .appendCeiling(new LevelTwoCeiling())
        .appendCoat(new LiBangCoat())
        .appendTile(new MarcoPoloTile());
  }

  public IMenu levelThree(BigDecimal area){
    return new PackageMenu(area,"现代简约")
        .appendCeiling(new LevelOneCeiling())
        .appendCoat(new LiBangCoat())
        .appendCoat(new DongPengTile());
  }

}

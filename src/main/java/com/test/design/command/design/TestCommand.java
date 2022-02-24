package com.test.design.command.design;

import com.test.design.command.design.cook.impl.GuangDongCook;
import com.test.design.command.design.cook.impl.JiangSuCook;
import com.test.design.command.design.cook.impl.ShangDongCook;
import com.test.design.command.design.cook.impl.SiChuanCook;
import com.test.design.command.design.cuisine.impl.GuangDongCuisine;
import com.test.design.command.design.cuisine.impl.JIangSuCuisine;
import com.test.design.command.design.cuisine.impl.ShangDongCuisine;
import com.test.design.command.design.cuisine.impl.SichuanCuisine;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:27
 * @description: 测试类
 * <p>
 * 菜品相当于命令，厨师为命令的具体实现，小二为命令的调用者
 * <p>
 * 从以上的内容和例子可以感受到，命令模式的使用场景需要分为三个比较大的块；命令、实现、调用者，而这三块内容的拆分也是选择适合场景的关键因素，经过这样的拆分可以让逻辑具备单一职责的性质，便于扩展。
 * 通过这样的实现方式与if语句相比，降低了耦合性也方便其他的命令和实现的扩展。但同时这样的设计模式也带来了一点问题，就是在各种命令与实现的组合下，会扩展出很多的实现类，需要进行管理。
 * 设计模式的学习一定要勤加练习，哪怕最开始是模仿实现也是可以的，多次的练习后再去找到一些可以优化的场景，并逐步运用到自己的开发中。提升自己对代码的设计感觉，让代码结构更加清晰易扩展。
 **/
public class TestCommand {

  @Test
  public void testCommand() {
    GuangDongCuisine guangDoneCuisine = new GuangDongCuisine(new GuangDongCook());
    JIangSuCuisine jiangSuCuisine = new JIangSuCuisine(new JiangSuCook());
    ShangDongCuisine shanDongCuisine = new ShangDongCuisine(new ShangDongCook());
    SichuanCuisine siChuanCuisine = new SichuanCuisine(new SiChuanCook());

    // 点单
    XiaoEr xiaoEr = new XiaoEr();
    xiaoEr.order(guangDoneCuisine);
    xiaoEr.order(jiangSuCuisine);
    xiaoEr.order(shanDongCuisine);
    xiaoEr.order(siChuanCuisine);

    // 下单
    xiaoEr.placeOrder();
  }

}

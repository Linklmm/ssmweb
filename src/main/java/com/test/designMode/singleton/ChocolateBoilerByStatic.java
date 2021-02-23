package com.test.designMode.singleton;


/**
 * Description 单例模式的巧克力锅炉
 *
 * @author playboy
 * @date 2020-01-10 14:21
 * version 1.0
 * 通过静态初始化器中创建单件。保证了线程安全
 */
public class ChocolateBoilerByStatic {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoilerByStatic uniqueInstance = new ChocolateBoilerByStatic();

    public static ChocolateBoilerByStatic getInstance() {
        return uniqueInstance;
    }

    private ChocolateBoilerByStatic() {
        this.empty = true;
        this.boiled = false;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            //在锅炉内填满巧克力和牛奶的混合物
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            //排出煮沸的巧克力和牛奶
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            //将炉内物煮沸
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}

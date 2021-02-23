package com.test.designMode.templateMethod;


import lombok.extern.slf4j.Slf4j;

/**
 * Description 测试模板方法
 *
 * @author playboy
 * @date 2020-03-03 15:42
 * version 1.0
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        Tea myTea = new Tea();
        myTea.prepareRecipe();
    }
}

package com.test.designMode.prototype;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 原型模式
 *
 * @author playboy
 * @date 2020-06-17 08:19
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements Cloneable {
    private String name;
    private Integer id;
    private School school;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

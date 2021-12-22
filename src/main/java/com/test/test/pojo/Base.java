package com.test.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author link.liu
 * @version 1.0.0
 * @className Base.java
 * @description TODO
 * @createTime 2020年08月20日 15:27:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Base {
    private int i;
    private int j;
    private Boolean b = Boolean.FALSE;
}

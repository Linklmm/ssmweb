package com.test.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author link.liu
 * @version 1.0.0
 * @className Base.java
 * @description TODO
 * @createTime 2020年08月20日 15:27:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    private int i;
    private int j;
    private Boolean b = Boolean.FALSE;
}

package com.test.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author link.liu
 * @version 1.0.0
 * @className BaseResponse.java
 * @description TODO
 * @createTime 2020年08月20日 15:28:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private int code;
    private List<Base> bases;
}

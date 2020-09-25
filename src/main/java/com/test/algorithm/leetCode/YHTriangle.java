package com.test.algorithm.leetCode;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角2
 */
@Slf4j
public class YHTriangle {
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        } else if (rowIndex == 1) {
            return Lists.newArrayList(1, 1);
        } else {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            List<Integer> preResult = getRow(rowIndex - 1);
            for (int i = 0; i + 1 < preResult.size(); i++) {
                Integer num = preResult.get(i) + preResult.get(i + 1);
                result.add(num);
            }
            result.add(1);
            return result;
        }

    }

    public static void main(String[] args) {
        log.error(JSON.toJSONString(getRow(33)));
    }
}

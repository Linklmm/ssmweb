package com.test.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.test.test.pojo.Base;
import com.test.test.pojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

@Slf4j
public class Test2 {
    @Test
    public void testArray() {
        Base base1 = new Base(11, 11, false);
        Base base2 = new Base(12, 12, true);
        List<Base> bases = Lists.newArrayList(base1, base2);
        Base arrayBase = bases.stream().findFirst().get();
        log.error("array:{}", JSON.toJSONString(bases));
        log.error("findAndy:{}",JSON.toJSONString(bases.stream().findAny()));
        arrayBase.setI(111);
        log.error("array:{}", JSON.toJSONString(bases));
    }

    @Test
    public void testJson() {
        BaseResponse baseResponse = new BaseResponse();
        List<Base> bases = null;
        baseResponse.setBases(null == bases || bases.isEmpty() ? Collections.emptyList() : bases);
        log.error("baseResponse:{}", JSON.toJSONString(baseResponse));
    }
}

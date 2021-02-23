package com.test.sourceCode.thread;


import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

/**
 * Description 测试ThreadLocal
 *
 * @author playboy
 * @date 2020-03-10 21:34
 * version 1.0
 */
@Slf4j
public class TestThreadLocal {
    /**
     * threadLocal中保存的数据是map
     */
    static final ThreadLocal<Map<String, String>> context = new ThreadLocal<>();

    @Test
    public void testThread() {
        //从上下文中拿出 map
        Map<String, String> contextMap = context.get();
        if (CollectionUtils.isEmpty(contextMap)) {
            contextMap = Maps.newHashMap();
        }
        contextMap.put("key1", "value");
        context.set(contextMap);
        log.info("key1, value被放到上下文中");
        getFormContext();
    }

    private String getFormContext() {
        String value = context.get().get("key1");
        log.info("从ThreadLocal中取出上下文，key1 对应的值为:{}", value);
        return value;
    }

}

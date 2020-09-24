package com.test.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.test.test.pojo.User;

import java.util.*;

/**
 * Description 实现类
 *
 * @author playboy
 * @date 2020-06-19 09:19
 * version 1.0
 */
public class ABImpl implements B {
    @Override
    public void say() {
        System.out.println("ab");
    }

    @Override
    public void sayC() {
        System.out.println("c Implements");
    }

    public static void main(String[] args) {
//        B ab = new ABImpl();
//        ab.say();
//        User user = new User();
//        System.out.println(user.getTest());
//        System.out.println(JSON.toJSONString(user));

        Map<String, String> map = System.getenv();
        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.print(entry.getKey() + " = ");
            System.out.println(entry.getValue());
        }

        System.out.println("=============自定义==============");
        System.out.println(map.get("key"));

        String string = "[abc,123,def,dnf,lol]";
        List<String> ss = Arrays.asList(string.substring(1, string.length() - 1).split(","));
        System.out.println("==================");
        System.out.println(JSON.toJSONString(ss));
    }
}

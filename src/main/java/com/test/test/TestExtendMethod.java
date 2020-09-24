package com.test.test;

import com.alibaba.fastjson.JSON;
import com.test.test.pojo.Base;
import com.test.test.pojo.BaseResponse;
import com.test.test.pojo.RequestA;
import com.test.test.pojo.ResponseA;

/**
 * @author link.liu
 * @version 1.0.0
 * @className TestExtendMethod.java
 * @description 测试继承类
 * @createTime 2020年08月20日 15:29:00
 */
public class TestExtendMethod {
    private BaseResponse extendMethod(Base base){
        System.out.println(JSON.toJSONString(base));
        System.out.println(base.getI());
        if (base instanceof RequestA){
            ((RequestA) base).setName("23333");
        }
        return new BaseResponse();
    }

    private void testOverload(BaseResponse br){
        System.out.println("1");
    }
    private void testOverload(ResponseA ba){
        System.out.println("2");
    }

    public static void main(String[] args) {
        TestExtendMethod tem = new TestExtendMethod();
        RequestA r = new RequestA();
        r.setName("lllll");
        BaseResponse ra =tem.extendMethod(r);
        System.out.println(JSON.toJSONString(r));
//        ResponseA responseA = new ResponseA();
//        BaseResponse baseResponse = new BaseResponse();
//        tem.testOverload(responseA);
//        tem.testOverload(baseResponse);
    }
}

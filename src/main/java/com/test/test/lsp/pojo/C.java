package com.test.test.lsp.pojo;

public class C extends B {
    @Override
    public B say() {
        System.out.println("I'm C");
        return null;
    }
}

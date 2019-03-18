package com.test.instruction;

import org.apache.ibatis.javassist.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-15 15:09
 * @Version 1.0
 * @Description
 */
public class ClassFileTransformer implements java.lang.instrument.ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        byte[] transformed = null;
        System.out.println("Transforming "+className);
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try {
            cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
            if (cl.isInterface() == false){
                CtBehavior[] methods = cl.getDeclaredBehaviors();
                for (int i=0;i<methods.length;i++){
                    if (methods[i].isEmpty() == false){
                        //修改method字节码
                        doMethod(methods[i]);
                    }
                }
                transformed = cl.toBytecode();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cl != null){
                cl.detach();
            }
        }
        return transformed;
    }


    private void doMethod(CtBehavior method)
            throws NotFoundException,CannotCompileException{
        method.insertBefore("long stime = System.nanoTime();");
//        method.insertAfter("System.out.println(/ "leave "+method.getName()+" and time:/"
//        +(System.nanoTime()-stime));");
    }
}

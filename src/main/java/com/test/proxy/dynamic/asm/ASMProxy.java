package com.test.proxy.dynamic.asm;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM5;

import com.test.proxy.dynamic.asm.impl.UserApi;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-14 22:28
 * @description: ASM动态代理
 *
 * 这种代理就是使用字节码编程的方式进行处理，它的实现方式相对复杂，而且需要了解Java虚拟机规范相关的知识。
 * 因为你的每一步代理操作，都是在操作字节码指令，
 * 例如：Opcodes.GETSTATIC、Opcodes.INVOKEVIRTUAL，除了这些还有小200个常用的指令。
 * 但这种最接近底层的方式，也是最快的方式。所以在一些使用字节码插装的全链路监控中，会非常常见。
 **/
@Slf4j
public class ASMProxy extends ClassLoader {

  public static <T> T getProxy(Class clazz) throws Exception {
    ClassReader classReader = new ClassReader(clazz.getName());
    ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);

    classReader.accept(new ClassVisitor(ASM5, classWriter) {
      @Override
      public MethodVisitor visitMethod(int access, final String name, String descriptor,
          String signature,
          String[] exceptions) {
        //方法过滤
        if (!"queryUserInfo".equals(name)) {
          return super.visitMethod(access, name, descriptor, signature, exceptions);
        }

        //得到方法
        final MethodVisitor methodVisitor = super
            .visitMethod(access, name, descriptor, signature, exceptions);

        return new AdviceAdapter(ASM5, methodVisitor, access, name, descriptor) {
          @Override
          protected void onMethodEnter() {
            //执行指令：获取静态属性
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
                Type.getObjectType("java/io/PrintStream").getDescriptor());
            //加载常量 Loader constant
            methodVisitor.visitLdcInsn(name + " 你被代理了，by ASM");
            //调用方法
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V", false);
            super.onMethodEnter();
          }
        };
      }
    }, ClassReader.EXPAND_FRAMES);
    byte[] bytes = classWriter.toByteArray();
    return (T) new ASMProxy().defineClass(clazz.getName(), bytes, 0, bytes.length).newInstance();
  }

  @Test
  public void testAsmProxy() throws Exception {
    IUserApi userApi = ASMProxy.getProxy(UserApi.class);
    String invoke = userApi.queryUserInfo();
    log.error("invoke:{}", invoke);
  }

  public static void main(String[] args) throws Exception {
    IUserApi userApi = ASMProxy.getProxy(UserApi.class);
    String invoke = userApi.queryUserInfo();
    log.error("invoke:{}", invoke);
  }

}

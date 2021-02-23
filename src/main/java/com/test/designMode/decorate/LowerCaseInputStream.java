package com.test.designMode.decorate;


import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description 把输入流内的所有大写字符转换成小写 装饰者
 * FilterInputStream 是所有inputStream的抽象装饰者
 *
 * @author playboy
 * @date 2019-12-27 10:28
 * version 1.0
 */
public class LowerCaseInputStream extends FilterInputStream {
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase(c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }

}

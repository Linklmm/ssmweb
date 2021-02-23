package com.test.serialize.externalize;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import lombok.Data;

/**
 * Description 通过Externalizable接口实现序列化
 *
 * @author playboy
 * @date 2020-04-27 08:42
 * version 1.0
 * 需要无参构造方法，该序列化是通过无参构造方法生成新的对象，然后再对其字段进行赋值
 */
@Data
public class User implements Externalizable {
    private static final long serialVersionUID = 6326047467971349104L;
    private String name;
    private int age;

    public User() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //out.writeObject(name);
        //out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //name = (String) in.readObject();
        //age = in.readInt();
    }

}

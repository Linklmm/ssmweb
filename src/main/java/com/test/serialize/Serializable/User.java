package com.test.serialize.Serializable;


import java.io.Serializable;
import lombok.Data;

/**
 * Description 通过Serializable接口实现序列化
 * @author playboy
 * @date 2020-04-27 08:57
 * version 1.0
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = -2016587864708306796L;

	private String name;
	private int age;
}

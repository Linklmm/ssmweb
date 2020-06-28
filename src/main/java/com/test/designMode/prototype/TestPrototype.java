package com.test.designMode.prototype;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 测试原型模式
 * @author playboy
 * @date 2020-06-17 08:20
 * version 1.0
 */
@Slf4j
public class TestPrototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		School school = new School("hut");
		People people = new People("cyp", 111, school);
		People people2 = (People) people.clone();
		log.error("修改之前");
		log.error("people:{}，p.getName：{}", JSON.toJSONString(people), people.getName().hashCode());
		log.error("people2:{},p2.getName:{}", JSON.toJSONString(people2), people2.getName().hashCode());
		people2.setName("lmm");

		school.setName("hut2");

		log.error("修改之后");
		log.error("people:{},p.getName：{}", JSON.toJSONString(people), people.getName().hashCode());
		log.error("people2:{},p2.getName:{}", JSON.toJSONString(people2), people2.getName().hashCode());

		//这里是直接生成一个新的string对象"hut3" 赋值给了Name，直接修改了对象成员变量的内存地址
		people.setName("hut3");
		log.error("people:{},p.getName：{}", JSON.toJSONString(people), people.getName().hashCode());
		log.error("people1:{},p2.getName：{}", JSON.toJSONString(people2), people2.getName().hashCode());
	}

}

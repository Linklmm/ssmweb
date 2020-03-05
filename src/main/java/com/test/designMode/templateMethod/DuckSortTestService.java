package com.test.designMode.templateMethod;


import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 鸭子排序测试
 * @author playboy
 * @date 2020-03-03 18:09
 * version 1.0
 */
@Slf4j
public class DuckSortTestService {
	public static void main(String[] args) {
		Duck[] ducks = {
				new Duck("daffy", 8),
				new Duck("dewey", 2),
				new Duck("howard", 7),
				new Duck("Louie", 2),
				new Duck("flower", 10),
				new Duck("grass", 2)
		};
		//Duck duck = new Duck("cyp",23);
		//log.info("duck:{}",JSON.toJSONString(duck));
		log.info("before sorttin");
		log.info("docks:{}", JSON.toJSONString(ducks));
		Arrays.sort(ducks);
		log.info("ducks:{}", JSON.toJSONString(ducks));
	}

}

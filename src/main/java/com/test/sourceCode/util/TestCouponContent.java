package com.test.sourceCode.util;


import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description 测试优惠券文案
 * @author playboy
 * @date 2020-03-11 14:11
 * version 1.0
 */
@Slf4j
public class TestCouponContent {
	public static final String COUPON_USE = "&&";
	private static final String CONTENT = "[租车·1天免费体验券]\n";
	public static List<CouponUseContent> getCouponUseContents(String remark) {
		//String[] contents = remark.replaceFirst("\\[", "")
		//		.replaceAll("\\]\\n\\n", COUPON_USE)
		//		.replaceAll("\\]\\n", COUPON_USE)
		//		.replaceAll("\\]", COUPON_USE)
		//		.split("\\[");
		String contents1 = remark.replaceFirst("\\[","");
		log.info("contents1:{}",JSON.toJSONString(contents1));
		String contents2 = remark.replaceAll("\\]\\n\\n",COUPON_USE);
		log.info("contents2:{}",JSON.toJSONString(contents2));
		String contents3 = remark.replaceAll("\\]\\n",COUPON_USE);
		log.info("contents3:{}",JSON.toJSONString(contents3));
		String contents4 = remark.replaceAll("\\]",COUPON_USE);
		log.info("contents4:{}",JSON.toJSONString(contents4));
		String[] contents = contents4.split("\\[");
		log.info("contents:{}",JSON.toJSONString(contents));


		return Arrays.stream(contents).map(CouponUseContent::new).collect(Collectors.toList());
	}
	@Test
	public void test(){
		List<CouponUseContent> couponUseContents = getCouponUseContents(CONTENT);
		log.info(JSON.toJSONString(couponUseContents));
	}
}

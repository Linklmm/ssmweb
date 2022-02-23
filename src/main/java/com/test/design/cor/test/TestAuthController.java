package com.test.design.cor.test;

import com.alibaba.fastjson.JSON;
import com.test.design.cor.controller.AuthController;
import com.test.design.cor.design.AuthLink;
import com.test.design.cor.design.Level1AuthLink;
import com.test.design.cor.design.Level2AuthLink;
import com.test.design.cor.design.Level3AuthLink;
import com.test.design.cor.service.AuthService;
import java.text.ParseException;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-23 22:05
 * @description:
 **/
@Slf4j
public class TestAuthController {

  @Test
  public void testAuth() throws ParseException {
    AuthController authController = new AuthController();

    // 模拟三级负责人审批
    log.info("测试结果：{}",
        JSON.toJSONString(authController.doAuth("敏敏哥", "1000998004813441", new Date())));
    log.info("测试结果：{}", "模拟三级负责人审批，王工");
    AuthService.auth("1000013", "1000998004813441");

    // 模拟二级负责人审批
    log.info("测试结果：{}",
        JSON.toJSONString(authController.doAuth("敏敏哥", "1000998004813441", new Date())));
    log.info("测试结果：{}", "模拟二级负责人审批，张经理");
    AuthService.auth("1000012", "1000998004813441");

    // 模拟一级负责人审批
    log.info("测试结果：{}",
        JSON.toJSONString(authController.doAuth("敏敏哥", "1000998004813441", new Date())));
    log.info("测试结果：{}", "模拟一级负责人审批，段总");
    AuthService.auth("1000011", "1000998004813441");

    log.info("测试结果：{}", "审批完成");
  }

  @Test
  public void tesCor() throws ParseException {
    AuthLink authLink = new Level3AuthLink("1000013", "王工")
        .appendNext(new Level2AuthLink("1000012", "张经理")
            .appendNext(new Level1AuthLink("1000011", "段总")));

    log.info("责任链测试结果：{}", JSON.toJSONString(authLink.doAuth("敏敏哥", "1000998004813441", new Date())));

    // 模拟三级负责人审批
    AuthService.auth("1000013", "1000998004813441");
    log.info("测试结果：{}", "模拟三级负责人审批，王工");
    log.info("责任链测试结果：{}", JSON.toJSONString(authLink.doAuth("敏敏哥", "1000998004813441", new Date())));

    // 模拟二级负责人审批
    AuthService.auth("1000012", "1000998004813441");
    log.info("测试结果：{}", "模拟二级负责人审批，张经理");
    log.info("责任链测试结果：{}", JSON.toJSONString(authLink.doAuth("敏敏哥", "1000998004813441", new Date())));

    // 模拟一级负责人审批
    AuthService.auth("1000011", "1000998004813441");
    log.info("测试结果：{}", "模拟一级负责人审批，段总");
    log.info("责任链测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
  }
}

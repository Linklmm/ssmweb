package com.test.spring.aop.actualCombat.controller;


import com.test.spring.aop.actualCombat.AuthChecker;
import com.test.spring.aop.actualCombat.service.NeedLogService;
import com.test.spring.aop.actualCombat.service.NormalService;
import com.test.spring.aop.actualCombat.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description controller控制
 * @author playboy
 * @date 2020-03-16 17:00
 * version 1.0
 */
@RestController
public class DemoController {
	@Autowired
	private NeedLogService needLogService;
	@Autowired
	private NormalService normalService;
	@Autowired
	private SomeService someService;



	@RequestMapping(value = "/aop/http/alive",method = RequestMethod.GET)
	@ResponseBody
	public String alive(){
		return "服务一切正常";
	}

	@AuthChecker
	@RequestMapping(value = "/aop/http/user_info",method = RequestMethod.GET)
	public String callSomeInterface(){
		return "调用了 user_info 接口.";
	}

	/**
	 * 日志出入参打印测试
	 * 方法调用日志
	 * @return
	 */
	@GetMapping("/testLog")
	public String test(){
		needLogService.logMethod("lmm");
		try {
			needLogService.exceptionMethod();
		} catch (Exception e) {

		}
		normalService.someMethod();
		return "success";
	}

	/**
	 * 方法耗时统计
	 * @return
	 */
	@GetMapping("/testExpire")
	public String testExpire(){
		someService.someMethod();
		return "success";
	}
}

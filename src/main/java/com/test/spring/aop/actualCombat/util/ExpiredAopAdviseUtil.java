package com.test.spring.aop.actualCombat.util;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Description 计算方法的调用时间
 * @author playboy
 * @date 2020-03-17 14:57
 * version 1.0
 */
@Component
@Aspect
@Slf4j
public class ExpiredAopAdviseUtil {
	// 定义一个 Pointcut, 使用 切点表达式函数 来描述对哪些 Join point 使用 advise.
	@Pointcut("within(com.test.spring.aop.actualCombat.service.SomeService)")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object methodInvokeExpiredTime(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//开始
		Object retVal = pjp.proceed();
		stopWatch.stop();
		//结束

		// 上报到公司监控平台
		reportToMonitorSystem(pjp.getSignature().getDeclaringTypeName(), stopWatch.getTotalTimeMillis());

		return retVal;
	}

	public void reportToMonitorSystem(String methodName, long expiredTime) {
		log.info("---method {} invoked, expired time: {} ms---", methodName, expiredTime);
		//
	}

	public static void main(String[] args) {
		for (int i = 0;i<10;i++){
			if (i == 2){
				log.info("jin");
				break;
			}
			log.info("i:{}",i);
		}
	}
}

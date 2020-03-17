package com.test.spring.aop.actualCombat.util;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description 使用aop实现某个服务下的方法调用前后打印日志
 * @author playboy
 * @date 2020-03-17 11:02
 * version 1.0
 */
@Aspect
@Component
@Slf4j
public class LogUtil {
	@Pointcut("within(com.test.spring.aop.actualCombat.service.NeedLogService)")
	public void pointcut2(){

	}

	/**
	 * 它在一个符合要求的 joinpoint 方法调用前执行, 打印调用的方法名和调用的参数.
	 * @param joinpoint
	 */
	@Before("pointcut2()")
	public void logMethodInvokeParam(JoinPoint joinpoint){
		log.info("------before method {} invoker,param:{}---",joinpoint.getSignature().toShortString(),joinpoint.getArgs());
	}

	/**
	 * 这个 advice 会在方法调用成功后打印出方法名还反的参数.
	 * @param joinPoint
	 * @param retVal
	 */
	@AfterReturning(pointcut = "pointcut2()",returning = "retVal")
	public void logMethodInvokeResult(JoinPoint joinPoint,Object retVal){
		log.info("--after method {} invoker,result:{}",joinPoint.getSignature().toShortString(),joinPoint.getArgs());
	}

	/**
	 * 这个 advice 会在指定的 joinpoint 抛出异常时执行, 打印异常的信息.
	 * @param joinPoint
	 * @param exception
	 */
	@AfterThrowing(pointcut = "pointcut2()", throwing = "exception")
	public void logMethodInvokeException(JoinPoint joinPoint, Exception exception) {
		log.info("---method {} invoke exception: {}---", joinPoint.getSignature().toShortString(), exception.getMessage());
	}
}

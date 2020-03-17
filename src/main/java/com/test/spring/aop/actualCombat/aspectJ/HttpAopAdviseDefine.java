package com.test.spring.aop.actualCombat.aspectJ;


import java.io.Serializable;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Description AspectJ实现
 * @author playboy
 * @date 2020-03-16 16:46
 * version 1.0
 */

@Component
@Aspect
@Slf4j
public class HttpAopAdviseDefine implements Serializable {
	private static final long serialVersionUID = 912376092711481960L;

	//定义一个poincut,使用切点表达式函数 来描述对那些Join point使用advise
	@Pointcut("@annotation(com.test.spring.aop.actualCombat.AuthChecker)")
	public void pointCut(){

	}

	/**
	 * 定义advise
	 * @param joinPoint
	 * @return
	 */
	@Around("pointCut()")
	public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

		log.error("调用了advise");
		//检查用户所传递的token 是否合法
		String token = getUserToken(request);
		if (!token.equalsIgnoreCase("123456")){
			return "错误，权限不合法！";
		}
		return joinPoint.proceed();
	}

	private String getUserToken(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return "";
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase("user_token")) {
				return cookie.getValue();
			}
		}
		return "";
	}
}

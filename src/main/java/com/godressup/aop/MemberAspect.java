package com.godressup.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.godressup.domain.DressVO;

@Aspect
@Component
public class MemberAspect {

	@Before("execution(* readDress(..))")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("[BeforeMethod]: 메서드 호출 전");
		Signature sig = jp.getSignature();
		System.out.println("메서드 이름: " + sig.getName());
		Object[] obj = jp.getArgs();
		if(obj.length > 0) {
			System.out.println("인수값: " + obj[0]);
		}
		else {
			System.out.println("인수가 없습니다.");
		}
	}
	
	@After("execution(* readDress(..))")
	public void afterMethod() {
		System.out.println("[AfterMethod]: 메서드 호출 후");
	}
	
	@AfterReturning(value="execution(* read*(..))", returning="dress")
	public void afterReturningMethod(JoinPoint jp, DressVO dress) {
		System.out.println("[afterReturningMethod]: 메서드 호출 후");
		Signature sig = jp.getSignature();
		System.out.println("메서드 이름: " + sig.getName());
		Object[] obj = jp.getArgs();
		if(obj.length > 0) {
			System.out.println("인수값: " + obj[0]);
		}
		else {
			System.out.println("인수가 없습니다.");
		}
	}
	
	@Around("execution(* readDress(..))")
	public DressVO aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[AroundMethod before]: 메서드 호출 전");
		DressVO dress = (DressVO) pjp.proceed();
		System.out.println("[AroundMethod after]: 메서드 호출 후");
		return dress;
	}
	
	@AfterThrowing(value="execution(* readDress(..))", throwing="ex")
	public void afterThrowingMethod(Throwable ex) {
		// 메서드 호출이 예외를 내보냈을 때 호출되는 Advice
		System.out.println("[AfterThrowingMethod]: 예외 발생 후");
		System.out.println("exception value = " + ex.toString());
	}
}

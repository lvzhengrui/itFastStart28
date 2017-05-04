package org.lvzr.fast.java.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.After;  
import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.AfterThrowing;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;  
import org.springframework.stereotype.Component;  
  
@Component  
@Aspect  
public class SimpleAspect {  
	
    @Pointcut("execution(* org.lvzr.fast.spring.aop.aspectj.*Service*.*(..))")  
    public void pointCut() {  
    }  

    @Before("pointCut()")  
    public void before(JoinPoint joinPoint) {  
        //�����Ҫ�������ȡ���������д���  
        //Object[] args = joinPoint.getArgs();  
        System.out.println("-------before aspect executing");  
    }  
    
    @After("execution(* org.lvzr.fast.spring.aop.aspectj.*Service*.*(..))")  
    public void after(JoinPoint joinPoint) {  
        System.out.println("-------after aspect executed");  
    }  

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")  
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {  
        System.out.println("-------afterReturning executed, return result is "  
                + returnVal);  
    }  
  
    @Around("pointCut()")  
    public void around(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println("-------around start..");  
        try {  
            pjp.proceed();  
        } catch (Throwable ex) {  
            System.out.println("error in around");  
            throw ex;  
        }  
        System.out.println("-------around end");  
    }  
  
    @AfterThrowing(pointcut = "pointCut()", throwing = "error")  
    public void afterThrowing(JoinPoint jp, Throwable error) {  
        System.out.println("-------error:" + error);  
    }  
}  



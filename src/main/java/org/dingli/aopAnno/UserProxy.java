package org.dingli.aopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建增强类
 *
 * @author dingli
 */
@Component
@Aspect
@Order(3)
public class UserProxy {

    /**
     * 相同切入点抽取,表示对目标执行方法进行执行
     */
    @Pointcut(value = "execution(* org.dingli.aopAnno.User.add(..))")
    public void pointDemo() {

    }


    /**
     * 前置通知
     *
     * @Before 注解
     */
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("user的before前置通知");
    }

    @After(value = "pointDemo()")
    public void after() {
        System.out.println("after后置通知");
    }

    /**
     * 表示方法返回之前执行
     */
    @AfterReturning(value = "pointDemo()")
    public void afterReturning() {
        System.out.println("afterReturning最终通知");
    }

    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing() {
        System.out.println("afterThrowing异常通知");
    }

    /**
     * 环绕通知，对目标方法执行前后都做增强
     */
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around环绕之前通知");
        //表示需要执行的方法
        proceedingJoinPoint.proceed();
        System.out.println("around环绕之后通知");
    }
}

package org.dingli.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author personProxy
 */
@Component
@Aspect
@Order(3)
public class PersonProxy {


    /**
     * 前置通知
     * 多个增强类对同一个切点进行增强
     *
     * @Before 注解
     */
    @Before(value = "execution(* org.dingli.aop.User.add(..))")
    public void before() {
        System.out.println("Person的before前置通知");
    }
}

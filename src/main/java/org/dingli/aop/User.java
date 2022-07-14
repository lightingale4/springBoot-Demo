package org.dingli.aop;


import org.springframework.stereotype.Component;

/**
 * 创建类，类里面定义方法
 *
 * @author Administrator
 */
@Component
public class User {

    public void add() {
        System.out.println("add方法成功");
    }
}

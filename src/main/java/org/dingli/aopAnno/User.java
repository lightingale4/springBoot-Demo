package org.dingli.aopAnno;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 创建类，类里面定义方法
 *
 * @author Administrator
 */
@Component("user")
public class User {

    public void add() {
        System.out.println("add方法成功");
    }
}

package org.dingli;

import org.dingli.aop.User;
import org.dingli.config.ProxyConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class TestAop {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProxyConfig.class);
        User user = applicationContext.getBean(User.class);
        user.add();
    }
}

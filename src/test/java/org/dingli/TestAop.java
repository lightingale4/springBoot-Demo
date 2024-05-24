package org.dingli;

import com.xn.annotation.EnableMyBean;
import com.xn.props.MyBeanProperties;
import org.dingli.aop.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@EnableMyBean
public class TestAop {


    @Autowired
    private MyBeanProperties myBeanProperties;

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoApplication.class);
        User user = applicationContext.getBean(User.class);
        user.add();
    }

    @Test
    public void test2() {

        Long a = 1000L;
        Integer b = 200;

        if (a > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        System.out.println("name为:" + myBeanProperties.getName() + ",   id为:" + myBeanProperties.getId());
    }
}

package org.dingli;

import static org.junit.Assert.assertTrue;

import com.xn.props.MyBeanProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTest {
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private MyBeanProperties myBeanProperties;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("name为:" + myBeanProperties.getName() + ",   id为:" + myBeanProperties.getId());
    }
}

package org.dingli.config;

import org.dingli.aop.PersonProxy;
import org.dingli.aop.User;
import org.dingli.aop.UserProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ding.li
 */
@Configuration
@EnableAspectJAutoProxy
public class ProxyConfig {

    @Bean
    public User getUser() {
        return new User();
    }

    @Bean
    public UserProxy getUserProxy() {
        return new UserProxy();
    }

    @Bean
    public PersonProxy getPersonProxy() {
        return new PersonProxy();
    }

}

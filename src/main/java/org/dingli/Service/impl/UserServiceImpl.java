package org.dingli.Service.impl;


import org.dingli.Service.OrderService;
import org.dingli.Service.UserService;
import org.dingli.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Administrator
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private OrderService orderService;

    private static final String errorMessage = "没有对应的人员";

    UserEntity userEntity = new UserEntity();

    @PostConstruct()
    @Override
    public OrderService getOrderService(){
        return this.orderService = orderService;
    }

    @Override
    public String add(String name, Integer age, String hobbies) {
        UserEntity userEntity = getUserEntity(name, age, hobbies);
        return userEntity.toString();
    }

    private UserEntity getUserEntity(String name, Integer age, String hobbies) {
        userEntity.setId(1L);
        userEntity.setName(name);
        userEntity.setAge(age);
        userEntity.setHobbies(hobbies);
        return userEntity;
    }

    @Override
    public String getName(String id) {
        return "名字为:"+id;
    }
}
